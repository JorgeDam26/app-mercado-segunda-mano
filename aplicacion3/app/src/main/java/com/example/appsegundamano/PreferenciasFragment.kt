package com.example.appsegundamano

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat.recreate
import androidx.preference.PreferenceFragmentCompat

class PreferenciasFragment : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onResume() {
        super.onResume()
        preferenceManager.sharedPreferences?.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceManager.sharedPreferences?.unregisterOnSharedPreferenceChangeListener(this)

    }

    //Guardamos cada vez  que le damos al botón para realizar el cambio
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        when (key) {
            "prefModoOscuro" -> {
                val modoOscuroActivado = sharedPreferences?.getBoolean(key, false) ?: false
                cambiarAModoOscuro(modoOscuroActivado)
            }
        }
    }

    //Este metodo cambia de modo según el parametro pasado (según si está activado el o no el checkbox)
    private fun cambiarAModoOscuro(modoOscuroActivado: Boolean) {
        if (modoOscuroActivado) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Toast.makeText(requireContext(), "Cambiando a modo oscuro", Toast.LENGTH_SHORT).show()

        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            Toast.makeText(requireContext(), "Cambiando a modo claro", Toast.LENGTH_SHORT).show()

        }
        requireActivity().recreate()

    }

}