package com.picpay.desafio.android.data.remote.retrofit

import com.picpay.desafio.android.data.remote.model.User
import retrofit2.Call
import retrofit2.http.GET

interface PicPayService {

    @GET("users")
    fun getUsers(): Call<List<User>>
}