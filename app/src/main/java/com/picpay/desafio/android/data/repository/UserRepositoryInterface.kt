package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.model.User
import retrofit2.Call

interface UserRepositoryInterface {
    fun getUsers(): Call<List<User>>
}