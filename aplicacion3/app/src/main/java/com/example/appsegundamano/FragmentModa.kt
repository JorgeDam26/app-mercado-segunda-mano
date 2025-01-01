package com.example.appsegundamano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsegundamano.databinding.FragmentModaBinding


class FragmentModa : Fragment() {

    private lateinit var binding: FragmentModaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Creamos la vista en el fragment
        binding = FragmentModaBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

}