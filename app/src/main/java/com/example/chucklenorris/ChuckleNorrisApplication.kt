package com.example.chucklenorris

import android.app.Application
import com.example.chucklenorris.di.AppComponent
import com.example.chucklenorris.di.DaggerAppComponent

class ChuckleNorrisApplication : Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}