package com.picpay.desafio.android.ui

import androidx.recyclerview.widget.DiffUtil
import com.picpay.desafio.android.data.model.User

class UserListDiffCallback(
) : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: User, newItem: User) =
        oldItem == newItem
}