package com.example.android_sprint_networking_challenge.retrofit

import com.example.android_sprint_networking_challenge.model.Pokemon
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRetriever {

    companion object{
        const val BASE_URL = "https://pokeapi.co/"
    }

    fun getPokemon(): Call<List<Pokemon>>{
        val gSon = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gSon))
            .build()

        return retrofit.create(PokemonApiInterface::class.java).getPokemon()
    }
}