package com.example.chucklenorris.data.api

import com.example.chucklenorris.data.api.model.Response
import io.reactivex.Single
import javax.inject.Inject

class JokesRemoteDataSource @Inject constructor(
    private val jokeService: JokeService
) {
    fun getJokes(numberOfJokes: Int): Single<Response> = jokeService.getJokes(numberOfJokes)
}
