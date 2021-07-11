package com.alecbrando.anotherretrofitexample.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alecbrando.anotherretrofitexample.R
import com.alecbrando.anotherretrofitexample.view.holder.CatViewHolder
import com.bumptech.glide.Glide

class CatViewAdapter(private val list: List<String>) : RecyclerView.Adapter<CatViewHolder>() {

    private lateinit var p : ViewGroup

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        p = parent
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_view_holder, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        Glide.with(p.context).load(list[position]).into(holder.img);

    }

    override fun getItemCount() = list.size
}