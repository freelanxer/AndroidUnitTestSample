package com.freelanxer.androidunittestsample

import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SharedPreferenceManagerTest {

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val value = "A123456"
        val sharedPreferenceManager: ISharedPreferenceManager =
            SharedPreferenceManager(appContext)
        sharedPreferenceManager.saveString(PREF_USER_ID, value)
        val valueFromSP = sharedPreferenceManager.getString(PREF_USER_ID)
        assertEquals(value, valueFromSP)
    }
}