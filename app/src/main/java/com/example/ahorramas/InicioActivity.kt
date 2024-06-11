package com.example.ahorramas

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.ahorramas.databinding.ActivityInicioBinding
import com.google.android.material.navigation.NavigationView

class InicioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInicioBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Drawer Layout
        drawerLayout = findViewById(R.id.drawerLayout)

        // Toggle Button
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // NavigationView
        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation view item clicks here.
            when (menuItem.itemId) {
                // Ejemplo de acción al hacer clic en un elemento del menú
                R.id.nav_home -> {
                    Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                    // Aquí puedes poner la lógica para abrir otra actividad o realizar otra acción
                    true
                }
                else -> false
            }
        }

        // Cambio de activity para ir al historial
        binding.BtnHistorialInicio.setOnClickListener {
            val intent = Intent(this, HistorialActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
