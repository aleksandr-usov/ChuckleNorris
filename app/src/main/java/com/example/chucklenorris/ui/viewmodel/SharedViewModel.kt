package com.example.chucklenorris.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucklenorris.data.ChuckleNorrisRepository
import com.example.chucklenorris.data.api.model.Joke
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SharedViewModel constructor(
    private val chuckleNorrisRepository: ChuckleNorrisRepository
) : ViewModel() {

    private val _currentJokes = MutableLiveData<List<Joke>>()
    val currentJokes: LiveData<List<Joke>> = _currentJokes

    private val disposables = CompositeDisposable()

    fun getJokes(numberOfJokes: Int) {
        disposables.add(
            chuckleNorrisRepository.getJokes(numberOfJokes)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _currentJokes.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }
}