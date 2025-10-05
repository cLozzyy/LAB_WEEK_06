package com.example.lab_week_06;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide; // Make sure this import is present

public class ImageLoader {

    private final Context context;

    // Constructor to get the context
    public ImageLoader(Context context) {
        this.context = context;
    }

    // Add a method body with the implementation logic
    void loadImage(String url, ImageView target) {
        // Use Glide to load the image from the URL into the target ImageView
        Glide.with(context)
                .load(url)
                .centerCrop() // Optional: scales the image to fill the ImageView
                .into(target);
    }
}
