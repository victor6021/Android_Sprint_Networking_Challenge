package com.example.android_sprint_networking_challenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_sprint_networking_challenge.R
import com.example.android_sprint_networking_challenge.model.Pokemon
import com.example.android_sprint_networking_challenge.retrofit.PokemonApiInterface
import com.example.android_sprint_networking_challenge.retrofit.PokemonRetriever
import kotlinx.android.synthetic.main.activity_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity(), Callback<List<Pokemon>> {

    lateinit var pokemonService: PokemonApiInterface

    override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {

    }

    override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
        response.body()?.let{
            text_view_name.text = getPokemon().toString()
            text_view_id.text = getPokemonById("").toString()
            text_view_type.text = getPokemonType("").toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        PokemonRetriever().getPokemon().enqueue(this)

        val input = intent.getStringExtra("value")
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
