package com.picpay.desafio.android.ui

import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data.remote.model.User
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.utils.extensions.insertImage

class UserListItemViewHolder(
    private val binding: ListItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.run {
            name.text = user.name
            username.text = user.username

            insertImage(
                image = user.img,
                error = R.drawable.ic_round_account_circle,
                imageView = picture
            )
        }
    }
}