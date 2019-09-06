package com.example.android_sprint_networking_challenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_sprint_networking_challenge.R
import com.example.android_sprint_networking_challenge.model.Pokemon
import com.example.android_sprint_networking_challenge.retrofit.PokemonApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity(), Callback<List<Pokemon>> {

    lateinit var pokemonService: PokemonApiInterface

    override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val input = intent.getStringExtra("get")
    }

    private fun getPokemon(){
        pokemonService.getPokemon().enqueue(this)
    }

    private fun getPokemonById(pokemonId: String){
        pokemonService.getPokemonById(pokemonId).enqueue(this)
    }

    private fun getPokemonAbility(pokemonAbility: String){
        pokemonService.getPokemonAbility(pokemonAbility).enqueue(this)
    }

    private fun getPokemonType(pokemonType: String){
        pokemonService.getPokemonType(pokemonType).enqueue(this)
    }
}
