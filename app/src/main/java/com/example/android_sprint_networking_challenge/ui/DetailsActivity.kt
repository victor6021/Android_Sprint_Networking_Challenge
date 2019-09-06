package com.example.android_sprint_networking_challenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_sprint_networking_challenge.R
import com.example.android_sprint_networking_challenge.model.Pokemon
import com.example.android_sprint_networking_challenge.retrofit.PokemonApiInterface
import kotlinx.android.synthetic.main.activity_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity(), Callback<Pokemon> {

    lateinit var pokemonService: PokemonApiInterface

    override fun onFailure(call: Call<Pokemon>, t: Throwable) {

    }

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        response.body().let{
            text_view_name.text = response.body()?.name
            text_view_id.text = response.body()?.id.toString()
            text_view_type.text = response.body()?.types
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        pokemonService = PokemonApiInterface.Factory.create()

        val input = intent.getStringExtra("value")
        if (input == "simple"){
            title = "GET - Simple Request"
            getPokemon()
        } else if(input == "path") {
            title = "GET - Path Parameter: PokemonId"
            getPokemonById("1")
        }



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
