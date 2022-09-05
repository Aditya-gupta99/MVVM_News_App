package com.sparklead.newsapp.ui

import com.sparklead.newsapp.api.RetrofitInstance
import com.sparklead.newsapp.db.ArticleDatabase

class NewsRepository(
    val db : ArticleDatabase
){
    suspend fun getBreakingNews(countryCode : String, pageNumber: Int ) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(query : String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(query,pageNumber)
}