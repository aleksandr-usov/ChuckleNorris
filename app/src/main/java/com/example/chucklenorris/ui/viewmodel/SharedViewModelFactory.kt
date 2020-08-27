package com.example.chucklenorris.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucklenorris.data.ChuckleNorrisRepository
import javax.inject.Inject

class SharedViewModelFactory @Inject constructor(
    private val chuckleNorrisRepository: ChuckleNorrisRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SharedViewModel(chuckleNorrisRepository) as T
    }
}