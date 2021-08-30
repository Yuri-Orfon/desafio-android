package com.picpay.desafio.android.data.service

import com.picpay.desafio.android.data.model.User
import retrofit2.Call
import retrofit2.http.GET

interface PicPayService {

    companion object {
        const val BASE_URL = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
    }

    @GET("users")
    fun getUsers(): Call<List<User>>
}