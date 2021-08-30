package com.picpay.desafio.android.data.repository

import androidx.room.withTransaction
import com.picpay.desafio.android.data.dao.UserDataBase
import com.picpay.desafio.android.data.service.PicPayService
import com.picpay.desafio.android.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: PicPayService,
    private val db: UserDataBase
    )  {

    private val restaurantDao = db.userDao()

    fun getUsers() = networkBoundResource(
        query = {
            restaurantDao.getAllUsers()
        },
        fetch = {
            delay(2000)
            api.getUsers()
        },
        saveFetchResult = { users ->
            db.withTransaction {
                restaurantDao.deleteAllUsers()
                restaurantDao.insertUsers(users)
            }
        }
    )
}