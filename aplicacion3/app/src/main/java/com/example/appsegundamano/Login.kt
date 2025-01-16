package com.example.appsegundamano

import android.content.Intent
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsegundamano.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.

        //Configuramos el RecyclerView
        initRecyclerView()

        binding.btAutentificar.setOnClickListener(){
            showSimpleAlertDialog()
        }

    }

    //Inicializamos la lista con los usuarios guardados
    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        binding.RecyclerView.layoutManager = manager
        binding.RecyclerView.adapter = AdaptadorUsuarios(UsuariosProvider.usuariosList)

        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.RecyclerView.addItemDecoration(decoration)

    }

    private fun showSimpleAlertDialog() {
        AlertDialog.Builder(ContextThemeWrapper(this, R.style.newAppTheme))
            .setTitle("Validacion")
            .setMessage("Contraseña validada")
            .setPositiveButton("OK") { dialog, which ->
                if ( binding.txtPassword.text.toString() == "Admin123"){
                    startActivity(Intent(this, PantallaPrincipal::class.java))
                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            }.setIcon(R.drawable.ic_alert_dialog_validacion)
            .show()


    }


}