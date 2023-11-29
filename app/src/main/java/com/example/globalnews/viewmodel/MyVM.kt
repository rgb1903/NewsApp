package com.example.globalnews.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.globalnews.repos.Article
import com.example.globalnews.repos.Model
import com.example.globalnews.service.NewsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MyVM(application: Application) : AndroidViewModel(application) {
    val news = MutableLiveData<List<Article>>()
    val eM = MutableLiveData<Boolean>()
    val disposable = CompositeDisposable()
    val servis = NewsApiService()


    fun down(){
        disposable.add(servis.getData()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<Model>(){


                override fun onSuccess(t: Model) {
                    eM.value = false
                    news.value = t.articles

                }

                override fun onError(e: Throwable) {

                    eM.value = true
                    Log.d("Error",e.localizedMessage)
                }

            }))

    }

}