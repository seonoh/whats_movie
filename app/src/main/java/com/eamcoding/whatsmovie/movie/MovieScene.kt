package com.eamcoding.whatsmovie.movie

import com.eamcoding.whatsmovie.common.Scene
import com.eamcoding.whatsmovie.model.Movie

// movie 통신 성공시 해야할 작업들 명시
interface MovieScene : Scene {
    fun addData(moive : Movie)
    fun onLoadMovieSuccess(movie : Movie)
    fun onLoadFailed(err : String?)
}