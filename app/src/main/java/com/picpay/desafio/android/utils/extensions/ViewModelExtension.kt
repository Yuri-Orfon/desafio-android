package com.picpay.desafio.android.utils.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

//inline fun <reified T : ViewModel> ViewModelStoreOwner.viewModels(noinline factoryProvider: (() -> ViewModelProvider.Factory)? = null): Lazy<T> = lazy {
//    factoryProvider?.let {
//        ViewModelProvider(this, factoryProvider()).get(T::class.java)
//    } ?: ViewModelProvider(this).get(T::class.java)
//}