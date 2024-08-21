package com.freelanxer.androidunittestsample

import android.content.Context
import android.content.SharedPreferences

interface ISharedPreferenceManager {
    fun saveString(key: String, value: String)
    fun getString(key: String): String
}

class SharedPreferenceManager(
    private val context: Context
) : ISharedPreferenceManager {
    var sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    override fun saveString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).commit()
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }
}