package com.picpay.desafio.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _state = MutableLiveData<UserState>()
    val state: LiveData<UserState> = _state

    fun handleIntent(intent: UserIntent) {
        when(intent) {
            UserIntent.InitAdapter -> handleInitAdapter()
        }
    }

    private fun handleInitAdapter() {
        showUsers()
    }

    private fun showUsers() {
        repository.getUsers()
            .enqueue(object : Callback<List<User>> {
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    _state.value = UserState.DisplayError
                }

                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if (response.isSuccessful) {
                        response.body().let {
                            _state.value = it?.let { it1 -> UserState.DisplayUsers(it1) }
                        }
                    }
                }
            })
    }
}

sealed class UserState {
    data class DisplayUsers(val response: List<User>) : UserState()
    object DisplayError : UserState()
}

sealed class UserIntent {
    object InitAdapter : UserIntent()
}