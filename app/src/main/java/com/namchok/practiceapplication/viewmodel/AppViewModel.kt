package com.namchok.practiceapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.namchok.practiceapplication.AppServiceRepository
import com.namchok.practiceapplication.model.common.Article
import com.namchok.practiceapplication.repository.AppServiceRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AppViewModel(private val mRepository: AppServiceRepository): ViewModel(){

    var mListNews = MutableLiveData<ArrayList<Article>>()
    var error: MutableLiveData<String> = MutableLiveData()


    fun getListArtist(){
        viewModelScope.launch {
            mRepository.getNews("us").collect {
                if (it.isSuccess) {
                    it.data?.let { data ->
                        mListNews.value = data.articles
                    }
                } else {
                    error.value = it.message
                }
            }
        }

    }

}