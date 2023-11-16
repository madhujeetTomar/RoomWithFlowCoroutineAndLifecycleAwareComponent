package com.mj.LatestComponents.di

import android.content.Context
import androidx.room.Room
import com.mj.LatestComponents.model.local.db.AppDatabase
import com.mj.LatestComponents.model.local.db.UserDao
import com.mj.LatestComponents.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }

    @Singleton
    @Provides
    fun providesUserDao(appDatabase: AppDatabase) =
        appDatabase.userDao()

    @Singleton
    @Provides
    fun providesMainRepository(userDao: UserDao): MainRepository {
        return MainRepository(userDao)
    }
}