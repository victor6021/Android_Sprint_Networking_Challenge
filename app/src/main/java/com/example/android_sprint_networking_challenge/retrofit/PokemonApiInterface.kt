package com.example.android_sprint_networking_challenge.retrofit

import com.example.android_sprint_networking_challenge.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiInterface {

    @GET("/api/v2/pokemon/{name}")
    fun getPokemon(): Call<List<Pokemon>>

    @GET("/api/v2/pokemon/{id}")
    fun getPokemonById(@Path("id")pokemonId: String): Call<List<Pokemon>>

//    @GET()

    @GET("/api/v2/ability/{id or name}")
    fun getPokemonAbility(@Path("ability")pokemonAbility: String): Call<List<Pokemon>>

    @GET("/api/v2/type/{id or name}")
    fun getPokemonType(@Query("type")pokemonType: String): Call<List<Pokemon>>
}