package com.picpay.desafio.android.di

import android.app.Application
import androidx.room.Room
import com.picpay.desafio.android.data.dao.UserDataBase
import com.picpay.desafio.android.data.service.PicPayService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(PicPayService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun providePicPayService(retrofit: Retrofit): PicPayService =
         retrofit.create(PicPayService::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : UserDataBase =
        Room.databaseBuilder(app, UserDataBase::class.java, "user_database")
            .build()
}