package com.example.android_sprint_networking_challenge.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_sprint_networking_challenge.R
import com.example.android_sprint_networking_challenge.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var pokemonList = mutableListOf<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image_view_search.setOnClickListener {
            val value = edit_text.text
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("value", value)
            startActivity(intent)
        }
    }
        fun refreshList(){
            layout.removeAllViews()
            for((counter, pokemon) in pokemonList.withIndex()){
                layout.addView(pokemonListView(pokemon, counter))
            }
        }

        override fun onPostResume() {
            refreshList()
            super.onPostResume()
        }

        fun pokemonListView(pokemon: Pokemon, index: Int): TextView {
            var newPokemon = TextView(this)
            newPokemon.textSize = 24f
            newPokemon.id = index
            newPokemon.text = pokemon.name

            newPokemon.setOnClickListener {
                pokemonList.removeAt(newPokemon.id)
            }
            return newPokemon
        }
    }

