package com.namchok.practiceapplication.repository

import androidx.lifecycle.MutableLiveData
import com.namchok.practiceandroidspotify.datasource.AppServiceDatasource
import com.namchok.practiceapplication.AppServiceRepository
import com.namchok.practiceapplication.datasource.AppDatasource
import com.namchok.practiceapplication.model.ResultService
import com.namchok.practiceapplication.model.dao.NewsDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppServiceRepositoryImpl(var mDatasource: AppDatasource):AppServiceRepository {

    override suspend fun getNews(country: String): Flow<ResultService<NewsDao>> {
        var response = mDatasource.getNews(country)
        return response.map {
            if (it.isSuccess) {
                val list = it.data
                return@map ResultService.success(list)
            } else {
                return@map ResultService.error(it.message)
            }
        }
    }

}