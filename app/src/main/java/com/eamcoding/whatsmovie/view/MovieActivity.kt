package com.eamcoding.whatsmovie.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.eamcoding.whatsmovie.R
import com.eamcoding.whatsmovie.model.Movie
import com.eamcoding.whatsmovie.movie.MovieScene
import com.eamcoding.whatsmovie.presenter.MovieInfoPresenter
import org.koin.android.ext.android.inject

class MovieActivity : AppCompatActivity(), MovieScene {

    private val moviePresenter : MovieInfoPresenter by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        moviePresenter.apply {
            scene = this@MovieActivity
            requestMovieData()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onLoadMovieSuccess(movie: Movie) {
    }

    override fun onLoadFailed(err: String?) {
    }
}
