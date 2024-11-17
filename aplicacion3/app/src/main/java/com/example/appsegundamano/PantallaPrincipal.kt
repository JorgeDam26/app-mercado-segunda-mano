package com.example.appsegundamano


import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    val toolbar: MaterialToolbar = binding.cabezaApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

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
        }

        setSupportActionBar(toolbar)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mi_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_menu -> {
                true
            }

            R.id.menu_buscar -> {
                true
            }

            else -> {
                throw Resources.NotFoundException("Positions not found")
            }
        }
    }
}