package com.kazanov.kazanovmonthfourproject.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kazanov.kazanovmonthfourproject.model.Task


@Database (entities = [Task::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun taskDao(): TaskDao
}