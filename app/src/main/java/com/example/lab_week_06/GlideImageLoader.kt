package com.example.lab_week_06

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader(private val context: Context) {
    fun loadImage(url: String, target: ImageView) {
        Glide.with(context)
            .load(url)
            .centerCrop()
            .into(target)
    }
}


    