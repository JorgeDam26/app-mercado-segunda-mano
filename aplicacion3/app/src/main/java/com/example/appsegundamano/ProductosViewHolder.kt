package com.example.appsegundamano

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appsegundamano.databinding.ActivityItemProductoBinding

class ProductosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val binding = ActivityItemProductoBinding.bind(itemView)

    val txtView: TextView = binding.tvNombreProducto
    val img: ImageView = binding.ivChico
}