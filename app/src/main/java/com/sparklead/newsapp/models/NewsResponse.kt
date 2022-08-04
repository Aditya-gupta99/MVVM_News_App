package com.sparklead.newsapp.models

import com.sparklead.newsapp.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)