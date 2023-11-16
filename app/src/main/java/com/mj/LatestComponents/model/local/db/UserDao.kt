package com.mj.LatestComponents.model.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE  uid = :userIds ")
    suspend fun getById(userIds: Int): User

    @Insert
   suspend fun insert(users: User)

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun update(user: User)

}