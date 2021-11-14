package com.example.myfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.Insets.add
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM="item"

class MainActivity : AppCompatActivity() {
    private lateinit var bottomMenu: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomMenu = findViewById(R.id.bottom_menu)
        bottomMenu.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.menu -> {
                    val menuFragment = MenuFragment()
                    replaceFragment(menuFragment)
                }
                R.id.about -> {
                    val aboutFragment = AboutFragment()
                    replaceFragment(aboutFragment)
                }
            }
            true
        }
   //bottomMenu.selectedItemId=R.id.menu
    /*    bottomMenu.selectedItemId=
            if(savedInstanceState==null)R.id.menu
            else savedInstanceState.getInt(LAST_SELECTED_ITEM)*/
    bottomMenu.selectedItemId=savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?:R.id.menu
    }

    private fun replaceFragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }
    }
