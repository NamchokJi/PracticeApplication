package com.namchok.practiceapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.namchok.practiceandroidspotify.datasource.AppServiceDatasource
import com.namchok.practiceapplication.model.ResultService
import com.namchok.practiceapplication.model.dao.NewsDao
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface AppServiceRepository {

    suspend fun getNews(country: String): Flow<ResultService<NewsDao>>

}