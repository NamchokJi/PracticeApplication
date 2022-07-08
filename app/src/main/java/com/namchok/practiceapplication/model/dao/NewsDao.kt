package com.namchok.practiceapplication.model.dao

import com.namchok.practiceapplication.model.common.Article

data class NewsDao(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)