package com.eamcoding.whatsmovie.movie

import com.eamcoding.whatsmovie.presenter.MovieInfoPresenter
import com.eamcoding.whatsmovie.presenter.MovieInfoPresenterImpl
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val movieListModule : Module = module{
    factory {
        MovieInfoPresenterImpl(get()) as MovieInfoPresenter
    }
}