package com.proyect.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.proyect.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.nav_host_fragment_activity_main, HomeFragment())
            .commit()

        binding.navView.setOnItemSelectedListener { view ->
            when(view.itemId){
                R.id.navigation_home -> {
                    openFragment(HomeFragment())
                }
                R.id.navigation_dashboard -> {
                    openFragment(DashboardFragment())
                }
                R.id.navigation_notifications -> {
                    openFragment(NotificationsFragment())
                }
                R.id.navigation_new_Fragment -> {
                    openFragment(NewFragment())
                }
            }
            true
        }

    }
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment_activity_main, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}