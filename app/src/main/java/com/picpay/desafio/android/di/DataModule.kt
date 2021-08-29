package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.datasource.RetrofitDataSource
import com.picpay.desafio.android.data.datasource.UserDataSource
import com.picpay.desafio.android.data.repository.UserRepository
import com.picpay.desafio.android.data.repository.UserRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindUserRepository(
        userRepository: UserRepository
    ): UserRepositoryInterface

    @Singleton
    @Binds
    abstract fun bindUserDataSource(
        userDataSource: RetrofitDataSource
    ): UserDataSource
}