package com.mj.LatestComponents.repository

import com.mj.LatestComponents.model.local.db.User
import com.mj.LatestComponents.model.local.db.UserDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(private val userDao: UserDao) {


 suspend fun createUser(user: User)
 {
     userDao.insert(user)
 }
    suspend fun updateUser(user: User)
    {
        userDao.update(user)
    }

    suspend fun delete(user: User)
    {
        userDao.delete(user)
    }

    suspend fun getUserById(id: Int) : User
    {
       return userDao.getById(id)
    }

    suspend fun getAll()
    {
        userDao.getAll()
    }



    fun fetchData() = flow<String> {
        val listOfData = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K")
        listOfData.forEach {
            delay(1000)
            emit(it)
        }
    }
}