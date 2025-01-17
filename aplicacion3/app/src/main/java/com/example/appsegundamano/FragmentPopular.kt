package com.example.appsegundamano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsegundamano.databinding.FragmentPopularBinding


class FragmentPopular : Fragment() {

    //Creamos el binding
    private lateinit var binding: FragmentPopularBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Creamos la vista en el fragment
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        val view = binding.root

        //Configuramos el RecyclerView
        binding.rvPopular?.requestFocus()

        initRecyclerView()

        return view

    }

    private fun initRecyclerView(){

        val manager = LinearLayoutManager(requireActivity())
        binding.rvPopular?.layoutManager = manager

        //Obtengo los datos de la bbdd
        val productosHelper = ProductoConexionHelper
        val productosBBDD = productosHelper.obtenerProductos(requireActivity())

        //Configuro el recyclerView con los datos de la bbdd
        binding.rvPopular?.adapter = AdaptadorProductos(productosBBDD)

        val decoration = DividerItemDecoration(requireActivity(), manager.orientation)
        binding.rvPopular?.addItemDecoration(decoration)
    }

}