package com.rachel.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rachel.foodapp.R
import com.rachel.foodapp.databinding.ActivityMainBinding
import com.rachel.foodapp.fragment.BreakfastFragment
import com.rachel.foodapp.fragment.DessertFragment
import com.rachel.foodapp.fragment.VegetarianFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setCurrentFragment(BreakfastFragment())
        mainBinding.navMain.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_Breakfast ->setCurrentFragment(BreakfastFragment())
                R.id.ic_Vegetarian ->setCurrentFragment(VegetarianFragment())
                R.id.ic_Dessert ->setCurrentFragment(DessertFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMain, fragment)
            commit()
        }
    }
}