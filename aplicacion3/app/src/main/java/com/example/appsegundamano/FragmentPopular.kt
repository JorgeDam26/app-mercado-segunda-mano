package com.example.appsegundamano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsegundamano.databinding.FragmentModaBinding
import com.example.appsegundamano.databinding.FragmentPopularBinding


class FragmentPopular : Fragment() {


    private lateinit var binding: FragmentPopularBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Creamos la vista en el fragment
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

}