package com.example.appsegundamano

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdaptadorProductos(private val producto: MutableList<Producto>): RecyclerView.Adapter<ProductosViewHolder>() {

    private val selectedItems = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductosViewHolder(layoutInflater.inflate(R.layout.activity_item_producto, parent, false))
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {

        //Inicializamos la lista de los cantantes
        val producto = producto[position]
        holder.txtView.text = producto.nombre

        val imageResourceId = holder.itemView.context.resources.getIdentifier(
            producto.urlImagen, "drawable", holder.itemView.context.packageName
        )

        holder.img.setImageResource(imageResourceId)

    }


    override fun getItemCount(): Int {
        return producto.size
    }
}