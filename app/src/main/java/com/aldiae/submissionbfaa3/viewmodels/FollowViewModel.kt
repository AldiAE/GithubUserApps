package com.aldiae.submissionbfaa3.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.aldiae.submissionbfaa3.model.GithubUser
import com.aldiae.submissionbfaa3.networking.UserRepositories
import com.aldiae.submissionbfaa3.utils.Resource
import com.aldiae.submissionbfaa3.utils.TypeView

class FollowViewModel : ViewModel() {
    private val username: MutableLiveData<String> = MutableLiveData()

    private lateinit var type: TypeView

    val dataFollow: LiveData<Resource<List<GithubUser>>> = Transformations
        .switchMap(username) {
            when (type) {
                TypeView.FOLLOWER -> {
                    UserRepositories.getFollowers(it)
                }
                TypeView.FOLLOWING -> {
                    UserRepositories.getFollowing(it)
                }
            }
        }

    fun setFollow(user: String, typeView: TypeView) {
        if (username.value == user) {
            return
        }
        username.value = user
        type = typeView
    }
}