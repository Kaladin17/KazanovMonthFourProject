package com.kazanov.kazanovmonthfourproject.data.local.db

import androidx.room.*
import com.kazanov.kazanovmonthfourproject.model.Task

@Dao
interface TaskDao {

    @Query ("SELECT * FROM task")
    fun getAll(): List<Task>


    @Insert
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)
}