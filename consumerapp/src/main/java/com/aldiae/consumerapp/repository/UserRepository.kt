package com.aldiae.consumerapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.aldiae.consumerapp.datasource.UserDataSource
import com.aldiae.consumerapp.model.GithubUser
import kotlinx.coroutines.Dispatchers

class UserRepository(private val source: UserDataSource) {

    fun getUserList():LiveData<List<GithubUser>> = liveData(Dispatchers.IO){
        emit(source.getUsers())
    }
}