package com.namchok.practiceandroidspotify.datasource.blueprint

import com.namchok.practiceapplication.model.dao.NewsDao
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface AppServiceDatasourceInterface {

    @GET("v2/top-headlines")
    fun getNews(@Query("country") country: String,@Query("apiKey") apiKey: String): Deferred<Response<NewsDao>>

}