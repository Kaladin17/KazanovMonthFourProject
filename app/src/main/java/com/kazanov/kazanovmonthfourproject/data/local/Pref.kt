package com.kazanov.kazanovmonthfourproject.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Pref(private val context: Context) {

    private val pref: SharedPreferences = context.getSharedPreferences(TASK_PREF_NAME, MODE_PRIVATE)

    fun isUserSeen(): Boolean {
        return pref.getBoolean(USER_SEEN_KEY, false)
    }

    fun saveUserSeen() {
        pref.edit().putBoolean(USER_SEEN_KEY, true).apply()
    }

    fun saveUserName(name: String) {
        pref.edit().putString(USER_ENTER_NAME, name).apply()
    }

    fun getUserName(): String? = pref.getString(USER_ENTER_NAME, "").toString()

    fun saveImage(img: String) {
        pref.edit().putString(SAVE_IMAGE, img).apply()
    }

    fun getImage(): String {
        return pref.getString(SAVE_IMAGE, "").toString()
    }

    companion object {

        const val USER_SEEN_KEY = "user.seen"
        const val TASK_PREF_NAME = "TaskPref"
        const val USER_ENTER_NAME = "user.enter.name"
        const val SAVE_IMAGE = "user.key.image"
    }
}