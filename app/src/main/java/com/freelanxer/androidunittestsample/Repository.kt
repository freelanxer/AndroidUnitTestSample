package com.freelanxer.androidunittestsample

import android.content.Context

const val PREF_NAME = "USER_DATA"
const val PREF_USER_ID = "PREF_USER_ID"

class Repository constructor(
    val context: Context
) {

    fun saveUserId(id: String) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(PREF_USER_ID, id).apply()
    }

}