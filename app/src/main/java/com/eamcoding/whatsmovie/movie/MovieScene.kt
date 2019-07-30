package com.eamcoding.whatsmovie.movie

import com.eamcoding.whatsmovie.common.Scene
import com.eamcoding.whatsmovie.model.Movie

interface MovieScene : Scene {
    fun onLoadMovieSuccess(movie : Movie)
    fun onLoadFailed(err : String?)
}