package com.example.android_sprint_networking_challenge.retrofit

import com.example.android_sprint_networking_challenge.model.Pokemon
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiInterface {

    @GET("pokemon/{name}/")
    fun getPokemon(): Call<Pokemon>

    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id")pokemonId: Int): Call<Pokemon>

//    @GET()

    @GET("/ability/{id or name}/")
    fun getPokemonAbility(@Path("ability") pokemonAbility: String): Call<Pokemon>

    @GET("type/{id or name}/")
    fun getPokemonType(@Path("type") pokemonType: String): Call<Pokemon>

    class Factory {

        companion object {
            val BASE_URL = "https://pokeapi.co/api/v2/"
            val gSon = Gson()

            fun create(): PokemonApiInterface {

                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gSon))
                    .build()
                    .create(PokemonApiInterface::class.java)
            }
        }
    }
}