package com.namchok.practiceapplication.di

import com.namchok.practiceandroidspotify.datasource.AppServiceDatasource
import com.namchok.practiceandroidspotify.datasource.blueprint.AppServiceDatasourceInterface
import com.namchok.practiceapplication.AppServiceRepository
import com.namchok.practiceapplication.datasource.AppDatasource
import com.namchok.practiceapplication.datasource.BaseDataSource
import com.namchok.practiceapplication.repository.AppServiceRepositoryImpl
import com.namchok.practiceapplication.viewmodel.AppViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    factory{ AppServiceDatasource() }
    factory{ AppDatasource(appServiceDatasource = get()) }
    factory<AppServiceRepository> { AppServiceRepositoryImpl(mDatasource = get()) }
    viewModel { (AppViewModel(mRepository = get())) }

}