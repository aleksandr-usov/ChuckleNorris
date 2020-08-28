package com.example.chucklenorris

class LiveEvent<T>(private var data: T?) {

    fun getData(): T? {
        val result = data
        data = null
        return result
    }
}