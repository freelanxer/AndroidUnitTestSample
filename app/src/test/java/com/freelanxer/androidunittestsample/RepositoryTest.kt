package com.freelanxer.androidunittestsample

import android.content.Context
import android.content.SharedPreferences
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class RepositoryTest {

    @Test
    fun testSaveUserId() {
        val sharedPref = mockk<SharedPreferences>(relaxed = true)
        val sharedPrefEditor = mockk<SharedPreferences.Editor>(relaxed = true)
        val context = mockk<Context>(relaxed = true)

        every { context.getSharedPreferences(any(), any()) } returns sharedPref
        every { sharedPref.edit() } returns sharedPrefEditor
        every { sharedPrefEditor.putString(any(), any()) } returns sharedPrefEditor

        val userId = "A123456"
        val repository = Repository(context)
        repository.saveUserId(userId)

        verify { sharedPrefEditor.putString(eq(PREF_USER_ID), eq(userId)) }
        verify { sharedPrefEditor.apply() }
    }

    @Test
    fun testSaveUserIdLocal() {
        val mockSharedPrefManager = mockk<ISharedPreferenceManager>(relaxed = true)
        val userId = "A123456"
        val repository = RepositoryForInstrumented(mockSharedPrefManager)
        repository.saveUserId(userId)
        verify { mockSharedPrefManager.saveString(PREF_USER_ID, userId) }
    }
}