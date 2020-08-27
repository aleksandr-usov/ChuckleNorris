package com.example.chucklenorris.di

import com.example.chucklenorris.ChuckleNorrisApplication
import com.example.chucklenorris.ui.JokesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class
    ]
)

@Singleton
interface AppComponent {
    fun inject(jokeFragment: JokesFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: ChuckleNorrisApplication): Builder
        fun build(): AppComponent
    }
}