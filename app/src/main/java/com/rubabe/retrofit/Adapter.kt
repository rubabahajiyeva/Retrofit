package com.rubabe.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter(private val mContext: Context, private val list: List<DTO>)

    : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView
        var textView: TextView


        init {
            imageView = view.findViewById(R.id.imageView)
            textView = view.findViewById(R.id.textView)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val design = LayoutInflater.from(mContext).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(design)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.textView.text = item.bio
        Picasso.get()
            .load(item.imageurl)
            .into(holder.imageView)
    }
}