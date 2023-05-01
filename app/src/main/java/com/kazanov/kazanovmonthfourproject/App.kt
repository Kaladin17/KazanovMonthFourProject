package com.kazanov.kazanovmonthfourproject

import android.app.Application
import androidx.room.Room
import com.kazanov.kazanovmonthfourproject.data.local.db.AppDataBase

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        db= Room.databaseBuilder(
            applicationContext, AppDataBase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }

    companion object{
        lateinit var db: AppDataBase
    }
}