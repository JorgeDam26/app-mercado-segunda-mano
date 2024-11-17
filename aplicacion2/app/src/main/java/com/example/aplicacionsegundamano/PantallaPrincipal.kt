package com.example.aplicacionsegundamano

import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.aplicacionsegundamano.databinding.ActivityPantallaPrincipalBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PantallaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaPrincipalBinding

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar el layout usando View Binding
        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root) // Establecer el contenido de la actividad

/*        // Inicializar las vistas usando el binding
        tabLayout = binding.tabLayout // Usar binding para acceder a tabLayout
        viewPager = binding.ViewPager2 // Usar binding para acceder a ViewPager2
        viewPager.adapter = PagerAdapter(this)
*/
/*        // Configurar TabLayout con ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> "Popular"
                1 -> "Moda"
                2 -> "Deportes"
                3 -> "Tecnologia"
                else -> throw Resources.NotFoundException("Posicion incorrecta")
            }
        }.attach()
*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mi_menu, menu)
        return true
    }

    /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.buscar -> {
                true
            }
            R.id.menu -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    */
}