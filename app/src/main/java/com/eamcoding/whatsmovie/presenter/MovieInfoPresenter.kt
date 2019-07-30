package com.eamcoding.whatsmovie.presenter

import com.eamcoding.whatsmovie.common.Presenter
import com.eamcoding.whatsmovie.movie.MovieScene

abstract class MovieInfoPresenter : Presenter<MovieScene>() {
    abstract fun requestMovieData()
}