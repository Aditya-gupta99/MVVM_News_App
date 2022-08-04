package com.sparklead.newsapp.ui

import androidx.lifecycle.ViewModel
import com.sparklead.newsapp.db.ArticleDatabase

class NewsRepository(
    val db : ArticleDatabase
): ViewModel() {


}