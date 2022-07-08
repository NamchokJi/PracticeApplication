package com.namchok.practiceandroidspotify.services

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class ProjectServiceBase<T>{

    protected fun appService(): Retrofit {
        val builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .client(UnsafeOkHttpClient.unsafeOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
        return builder.build()
    }

}

