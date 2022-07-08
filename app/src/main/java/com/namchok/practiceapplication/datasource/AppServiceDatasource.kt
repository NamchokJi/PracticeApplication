package com.namchok.practiceandroidspotify.datasource

import com.namchok.practiceandroidspotify.datasource.blueprint.AppServiceDatasourceInterface
import com.namchok.practiceandroidspotify.services.ProjectServiceBase
import com.namchok.practiceapplication.model.dao.NewsDao
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response

class AppServiceDatasource: ProjectServiceBase<AppServiceDatasourceInterface>() {

    fun getInterface(): AppServiceDatasourceInterface {
        return appService().create(AppServiceDatasourceInterface::class.java)
    }

    fun getNews(country: String): Deferred<Response<NewsDao>> {
        return getInterface().getNews(country,"7fcf270f33d547988dca40a813cf80e1")
    }
}