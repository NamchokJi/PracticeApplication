package com.namchok.practiceapplication.datasource

import com.namchok.practiceandroidspotify.datasource.AppServiceDatasource
import com.namchok.practiceapplication.AppServiceRepository
import com.namchok.practiceapplication.model.ResultService
import com.namchok.practiceapplication.model.dao.NewsDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class AppDatasource(var appServiceDatasource: AppServiceDatasource):AppServiceRepository,BaseDataSource() {

    override suspend fun getNews(country: String): Flow<ResultService<NewsDao>> {
        val result = getResult(appServiceDatasource.getNews(country))
        return flowOf(result)
    }

}