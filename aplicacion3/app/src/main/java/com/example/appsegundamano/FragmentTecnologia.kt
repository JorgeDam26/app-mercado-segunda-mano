package com.example.appsegundamano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsegundamano.databinding.FragmentPopularBinding
import com.example.appsegundamano.databinding.FragmentTecnologiaBinding


class FragmentTecnologia : Fragment() {

    private lateinit var binding: FragmentTecnologiaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTecnologiaBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }


}