package com.mj.LatestComponents.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mj.LatestComponents.model.local.db.User
import com.mj.LatestComponents.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val TAG = "MainViewModel"
    private val listOfStringMutableLiveData: MutableLiveData<List<String>> = MutableLiveData<List<String>>()


    val listOfStringLiveData:LiveData<List<String>> = listOfStringMutableLiveData


   fun insertUser()
   {
       viewModelScope.launch {
          val user = mainRepository.getUserById(1)
           if(!user.firstName.isNullOrEmpty())
           {
               Log.d("Madhujeet", "insertUser: ${user.firstName}")
           }
           else{
           mainRepository.createUser(User(1,"Madhujeet","Tomar"))
       }}
   }


    fun fetchLatestStringData()
    {
        viewModelScope.launch {
            mainRepository.fetchData().collect {
                Log.d(TAG, "fetchLatestStringData: $it")
            }
        }
    }







}