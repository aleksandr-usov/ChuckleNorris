package com.example.chucklenorris.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.chucklenorris.data.ChuckleNorrisRepository

class SharedViewModel constructor(
   private val chuckleNorrisRepository: ChuckleNorrisRepository
): ViewModel() {


}