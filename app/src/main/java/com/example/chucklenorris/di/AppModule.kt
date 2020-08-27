package com.example.chucklenorris.di

import android.content.Context
import com.example.chucklenorris.ChuckleNorrisApplication
import com.example.chucklenorris.data.api.JokeService
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Binds
    abstract fun provideDaggerApplication(application: ChuckleNorrisApplication): Context

    @Module
    companion object {
        @Provides
        @Singleton
        @JvmStatic
        fun provideService(): JokeService {
            val client = OkHttpClient.Builder()
            client.addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) })

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .baseUrl(JokeService.BASE_URL)
                .build()

            return retrofit.create(JokeService::class.java)
        }
    }
}