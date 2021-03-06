package com.picpay.desafio.android.data.datasource

import com.picpay.desafio.android.data.remote.model.User
import com.picpay.desafio.android.data.remote.retrofit.PicPayService
import retrofit2.Call
import javax.inject.Inject

interface UserDataSource {
    fun getUsers(): Call<List<User>>
}

class RetrofitDataSource @Inject constructor(
    private val service: PicPayService
) : UserDataSource {
    override fun getUsers(): Call<List<User>> = service.getUsers()
}