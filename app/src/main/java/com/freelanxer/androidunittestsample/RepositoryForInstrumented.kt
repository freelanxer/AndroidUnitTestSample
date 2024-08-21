package com.freelanxer.androidunittestsample

import android.content.Context

class RepositoryForInstrumented constructor(
    private val sharedPrefManager: ISharedPreferenceManager
) {

    fun saveUserId(id: String) {
        sharedPrefManager.saveString(PREF_USER_ID, id)
    }

}