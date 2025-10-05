// CatAdapter.kt
package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

// CatAdapter.kt
class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatViewHolder.OnClickListener
) : RecyclerView.Adapter<CatViewHolder>() {

    private val cats = mutableListOf<CatModel>()

    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        notifyDataSetChanged()
    }

    // === Tambahan untuk swipe delete ===
    fun removeAt(position: Int): CatModel {
        val removed = cats.removeAt(position)
        notifyItemRemoved(position)
        return removed
    }
    fun insertAt(position: Int, item: CatModel) {
        cats.add(position.coerceIn(0, cats.size), item)
        notifyItemInserted(position)
    }
    fun getItem(position: Int): CatModel = cats[position]
    // ===================================

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader, onClickListener)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindData(cats[position])
    }

    override fun getItemCount() = cats.size
}

