package com.example.chucklenorris.data

import com.example.chucklenorris.data.api.JokesRemoteDataSource
import com.example.chucklenorris.data.api.model.Joke
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChuckleNorrisRepository @Inject constructor(
    private val jokesRemoteDataSource: JokesRemoteDataSource
) {
    fun getJokes(numberOfJokes: Int): Single<List<Joke>> {
        return jokesRemoteDataSource.getJokes(numberOfJokes)
    }
}