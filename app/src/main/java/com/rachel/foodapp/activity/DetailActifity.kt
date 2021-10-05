package com.rachel.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rachel.foodapp.R
import com.rachel.foodapp.databinding.ActivityDetailActifityBinding
import com.rachel.foodapp.databinding.ActivityMainBinding
import com.rachel.foodapp.model.Recipes

class DetailActifity : AppCompatActivity() {
    companion object{
        const val RECIPE_DATA = "RECIPE_DATA"
    }

    private lateinit var detailBinding : ActivityDetailActifityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding =ActivityDetailActifityBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)

        }
        setSupportActionBar(detailBinding.tbDetail)
        val dataRecipes = intent.getParcelableExtra<Recipes>(RECIPE_DATA) as Recipes

        Glide.with(this).load(dataRecipes.pictures).into(detailBinding.ivDetail)

        detailBinding.tvNameDetail.text = dataRecipes.name
        detailBinding.tvCalories. text = dataRecipes.calories
        detailBinding.tvCarbo.text = dataRecipes.carbo
        detailBinding.tvProtein.text = dataRecipes.protein
        detailBinding.tvDetailDecripton.text = dataRecipes.description
        detailBinding.tvIngredients.text = dataRecipes.ingredients
        detailBinding.tvInstruction.text = dataRecipes.instructions

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}