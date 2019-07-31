package com.eamcoding.whatsmovie.presenter

import android.util.Log
import com.eamcoding.whatsmovie.config.CLIENT_ID
import com.eamcoding.whatsmovie.config.CLIENT_SECRET
import com.eamcoding.whatsmovie.network.Api
import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieInfoPresenterImpl(private val api : Api) : MovieInfoPresenter() {

    override fun requestMovieData() {
        var headerMap = mutableMapOf<String,String>()
        headerMap.put("X-Naver-Client-Id",CLIENT_ID)
        headerMap.put("X-Naver-Client-Secret", CLIENT_SECRET)

        Log.e("headermap",""+headerMap)
        compositeDisposable?.add(api.getMovieInfo(headerMap,"사자",100)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                scene?.onLoadMovieSuccess(it)
                for(i in 0 until it.movieList.size){

                    it.movieList[i].title = it.movieList[i].title.replace("""<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>""".toRegex(),"")
                    it.movieList[i].director = it.movieList[i].director.replace("\\|".toRegex(),".")
                    it.movieList[i].actor = it.movieList[i].actor.replace("\\|".toRegex(),".")
                }
            }, {
                scene?.onLoadFailed(it.message)

            })
        )
    }

}