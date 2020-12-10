package com.aldiae.consumerapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.aldiae.consumerapp.datasource.UserDataSource
import com.aldiae.consumerapp.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository

    init {
        val source = UserDataSource(application.contentResolver)
        repository = UserRepository(source)
    }

    var userLists = repository.getUserList()
}