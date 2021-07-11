package com.alecbrando.anotherretrofitexample.view.holder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alecbrando.anotherretrofitexample.R

class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var img = itemView.findViewById<ImageView>(R.id.cat_image)
}