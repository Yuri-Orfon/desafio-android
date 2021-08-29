package com.picpay.desafio.android.utils.extensions

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun View.setVisible(
    visible: Boolean,
    useInvisible: Boolean = false
) {
    visibility = when {
        visible -> View.VISIBLE
        useInvisible -> View.INVISIBLE
        else -> View.GONE
    }
}

fun insertImage(url: String, imageView: ImageView) {
    Picasso.get().load(url).into(imageView)
}