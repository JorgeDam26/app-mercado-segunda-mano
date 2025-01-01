package com.example.appsegundamano

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdaptadorUsuarios(private val usuarios: ArrayList<String>) : RecyclerView.Adapter<UsuariosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuariosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsuariosViewHolder(layoutInflater.inflate(R.layout.activity_item_usuario, parent, false))
    }

    override fun onBindViewHolder(holder: UsuariosViewHolder, position: Int) {

        //Inicializamos la lista de los cantantes
        val usuario = usuarios[position]
        holder.textView.text = usuario

        //Cuando hago click en algo de la lista...
        holder.textView.setOnClickListener {

        }

    }

    override fun getItemCount(): Int {
        return usuarios.size
    }
}