package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.datasource.UserDataSource
import com.picpay.desafio.android.data.remote.model.User
import retrofit2.Call
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDataSource: UserDataSource
    ) : UserRepositoryInterface {

    override fun getUsers(): Call<List<User>> = userDataSource.getUsers()
}