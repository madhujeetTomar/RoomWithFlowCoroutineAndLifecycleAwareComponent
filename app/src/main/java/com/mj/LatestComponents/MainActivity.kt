package com.mj.LatestComponents

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mj.LatestComponents.viewmodel.MainViewModel

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.fetchLatestStringData()
mainViewModel.insertUser()
        GlobalScope.launch {

            val result = producer()
            result.collect {
                Log.d(TAG, "MJ: ITEM1- $it")
            }
        }
        GlobalScope.launch {

            val result = producer().flowOn(Dispatchers.IO).map { it*2 }.filter { it<20 }
                .collect {
                Log.d(TAG, "MJ: ITEM2- $it")
            }
        }


    }

/*    fun producer(): Flow<Int> {
        val mutableSharedFlow = MutableSharedFlow<Int>()
        GlobalScope.launch {

            mutableSharedFlow.emit(10)
            delay(1000)
            mutableSharedFlow.emit(20)
            delay(1000)
            mutableSharedFlow.emit(30)
            delay(1000)
            mutableSharedFlow.emit(40)
            delay(1000)
            mutableSharedFlow.emit(40)
            delay(1000)
            mutableSharedFlow.emit(40)
            delay(1000)
            mutableSharedFlow.emit(40)
            delay(1000)
            mutableSharedFlow.emit(40)
            delay(1000)
            mutableSharedFlow.emit(40)
            delay(1000)
            mutableSharedFlow.emit(40)
        }
        return mutableSharedFlow
    }*/

    fun producer(): Flow<Int> {
        val mutableSharedFlow = MutableStateFlow<Int>(1)
        GlobalScope.launch {

            mutableSharedFlow.emit(10)
            delay(1000)
            mutableSharedFlow.emit(20)
            delay(1000)
            mutableSharedFlow.emit(30)
            delay(1000)
            mutableSharedFlow.emit(40)
            delay(1000)
            mutableSharedFlow.emit(50)
            delay(1000)
            mutableSharedFlow.emit(60)
            delay(1000)
            mutableSharedFlow.emit(70)
            delay(1000)
            mutableSharedFlow.emit(80)
            delay(1000)
            mutableSharedFlow.emit(90)
            delay(1000)
            mutableSharedFlow.emit(100)
        }
        return mutableSharedFlow
        /* return flow {
             val listOfInteger = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
             listOfInteger.forEach {
                 delay(1000)
                 emit(it)
             }
         }*/
    }
}