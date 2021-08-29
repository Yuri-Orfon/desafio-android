package com.picpay.desafio.android.ui

import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.utils.extensions.setVisible
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class UserListItemViewHolder(
    private val binding: ListItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.run {
            name.text = user.name
            username.text = user.username
            progressBar.setVisible(true)

            Picasso.get()
                .load(user.img)
                .error(R.drawable.ic_round_account_circle)
                .into(picture, object : Callback {
                    override fun onSuccess() {
                        progressBar.setVisible(false)
                    }

                    override fun onError(e: Exception?) {
                        progressBar.setVisible(false)
                    }
                })
        }
    }
}