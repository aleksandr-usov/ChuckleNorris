package com.example.chucklenorris.data.api

import com.example.chucklenorris.data.api.model.Joke
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface JokeService {
    companion object {
        const val BASE_URL = "http://api.icndb.com/jokes/random/"
    }

    @GET("{number_of_jokes}")
    fun getJokes(
        @Path(value = "number_of_jokes") numberOfJokes: Int
    ): Single<List<Joke>>
}