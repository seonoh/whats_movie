package com.eamcoding.whatsmovie.presenter

import android.util.Log
import com.eamcoding.whatsmovie.config.CLIENT_ID
import com.eamcoding.whatsmovie.config.CLIENT_SECRET
import com.eamcoding.whatsmovie.network.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieInfoPresenterImpl(private val api : Api) : MovieInfoPresenter() {

    override fun requestMovieData() {
        var headerMap = mutableMapOf<String,String>()
        headerMap.put("X-Naver-Client-Id",CLIENT_ID)
        headerMap.put("X-Naver-Client-Secret", CLIENT_SECRET)

        compositeDisposable?.add(api.getMovieInfo(headerMap,"고질라")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                scene?.onLoadMovieSuccess(it)
                Log.e("success","title : $it")
            }, {
                scene?.onLoadFailed(it.message)
                Log.e("failed","error  : $it")

            })
        )
    }

}