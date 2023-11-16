package com.mj.LatestComponents.repository

import com.mj.LatestComponents.model.local.db.User
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasksStream(): Flow<List<User>>

    suspend fun getTasks(forceUpdate: Boolean = false): List<User>

    fun getTaskStream(taskId: String): Flow<User?>

    suspend fun getTask(taskId: String, forceUpdate: Boolean = false): User?

    suspend fun createTask(title: String, description: String): String

    suspend fun updateTask(taskId: String, title: String, description: String)


    suspend fun clearCompletedTasks()

    suspend fun deleteAllTasks()

    suspend fun deleteTask(taskId: String)
}