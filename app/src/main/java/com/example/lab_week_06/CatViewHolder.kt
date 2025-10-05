package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide // Import Glide
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

private const val FEMALE_SYMBOL = "\u2640"
private const val MALE_SYMBOL = "\u2642"
private const val UNKNOWN_SYMBOL = "?"

class CatViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
    //containerView is the container layout of each item list
    //Here findViewById is used to get the reference of each views inside the container
    private val catBiographyView: TextView = containerView.findViewById(R.id.cat_biography)
    private val catBreedView: TextView = containerView.findViewById(R.id.cat_breed)
    private val catGenderView: TextView = containerView.findViewById(R.id.cat_gender)
    private val catNameView: TextView = containerView.findViewById(R.id.cat_name)
    private val catPhotoView: ImageView = containerView.findViewById(R.id.cat_photo)

    //This function is called in the adapter to provide the binding function
    fun bindData(cat: CatModel) {
        // Use Glide to load the image from the URL into the ImageView
        Glide.with(itemView.context)
            .load(cat.imageUrl)
            .into(catPhotoView)

        catNameView.text = cat.name
        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            else -> "Unknown"
        }
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }
}
