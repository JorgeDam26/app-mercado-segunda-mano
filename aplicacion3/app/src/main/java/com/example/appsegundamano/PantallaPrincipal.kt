package com.example.appsegundamano


import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.appsegundamano.databinding.ActivityPantallaPrincipalBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PantallaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaPrincipalBinding

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toolbar
        val toolbar: MaterialToolbar = binding.cabezaApp
        setSupportActionBar(toolbar)

        tabLayout = binding.tabLayout
        viewPager = binding.viewPager

        viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "Popular"
                }

                1 -> {
                    "Moda"
                }

                2 -> {
                    "Deportes"
                }

                3 -> {
                    "Tecnologia"
                }

                else -> {
                    throw Resources.NotFoundException("Positions not found")
                }
            }
        }.attach()

        //Autocomplete text view
        val products = resources.getStringArray(R.array.pantallas)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, products)
        binding.autocompleteTextView.setAdapter(adapter)

        binding.autocompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as String

            //Inica la actividad
            val intent = Intent(this, PantallaPrincipal::class.java)
            intent.putExtra("item_seleccionado", item)
            startActivity(intent)

            llevarAPantallaSeleccionada()

        }

    }

    private fun llevarAPantallaSeleccionada(){
        val pantallaSeleccionada = intent.getStringExtra("item_seleccionado")
        when (pantallaSeleccionada) {
            "Popular" -> {
                val toast = Toast.makeText(this, "Yendo a pantalla popular", Toast.LENGTH_SHORT)
                toast.show()

            }
            "Moda" -> {
                val toast = Toast.makeText(this, "Yendo a pantalla popular", Toast.LENGTH_SHORT)
                toast.show()

            }
            "Deportes" -> {
                val toast = Toast.makeText(this, "Yendo a pantalla popular", Toast.LENGTH_SHORT)
                toast.show()

            }
            "Tecnología" -> {
                val toast = Toast.makeText(this, "Yendo a pantalla popular", Toast.LENGTH_SHORT)
                toast.show()

            }
            else -> {
                throw Resources.NotFoundException("Positions not found")
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mi_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            /*R.id.preferencias -> {
                startActivity(Intent(this, PreferenciasFragment::class.java))
                true
            }*/
            R.id.acceso_pg_web -> {
                val webpage:Uri = Uri.parse("https://es.wallapop.com/")
                val webIntent:Intent = Intent(Intent.ACTION_VIEW, webpage)
                startActivity(webIntent)
                true
            }
            R.id.acerca_de -> {
                startActivity(Intent(this, AcercaDe2::class.java))
                true
            }
            else -> {
                throw Resources.NotFoundException("Positions not found")
            }
        }
    }



}