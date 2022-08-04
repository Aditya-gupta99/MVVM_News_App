package com.sparklead.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sparklead.newsapp.R
import com.sparklead.newsapp.ui.NewsActivity
import com.sparklead.newsapp.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
    }

}