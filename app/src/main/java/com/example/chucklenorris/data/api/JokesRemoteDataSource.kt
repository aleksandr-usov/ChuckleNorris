package com.example.chucklenorris.data.api

import com.example.chucklenorris.data.api.model.Joke
import io.reactivex.Single
import javax.inject.Inject

class JokesRemoteDataSource @Inject constructor(
    private val upDogService: JokeService
) {
    fun getJokes(numberOfJokes: Int): Single<List<Joke>> = upDogService.getJokes(numberOfJokes)
}
