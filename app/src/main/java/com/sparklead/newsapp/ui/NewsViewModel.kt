package com.sparklead.newsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sparklead.newsapp.models.NewsResponse
import com.sparklead.newsapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    private val newsRepository : NewsRepository
): ViewModel() {

    val breakingNews : MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private val breakingNewsPage = 1

    val searchNews : MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private val searchNewsPage = 1

    init {
        getBreakingNews("in")
    }

    fun getBreakingNews(countryCode :String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode,breakingNewsPage)
        breakingNews.postValue(handlerBreakingNewsResponse(response))
    }

    private fun handlerBreakingNewsResponse(response : Response<NewsResponse>) : Resource<NewsResponse>{
        if(response.isSuccessful){
            response.body().let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun getSearchNews(query :String) = viewModelScope.launch {

        searchNews.postValue(Resource.Loading())
        val response = newsRepository.searchNews(query,searchNewsPage)
        searchNews.postValue(handlerSearchNewsResponse(response))
    }

    private fun handlerSearchNewsResponse(response : Response<NewsResponse>) : Resource<NewsResponse>{
        if(response.isSuccessful){
            response.body().let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}