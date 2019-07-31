package com.eamcoding.whatsmovie.movie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.eamcoding.whatsmovie.R
import com.eamcoding.whatsmovie.model.Movie
import com.eamcoding.whatsmovie.movie.adapter.MovieAdapter
import com.eamcoding.whatsmovie.presenter.MovieInfoPresenter
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_movie.*
import org.koin.android.ext.android.inject

class MovieActivity : AppCompatActivity(), MovieScene {

    private val moviePresenter : MovieInfoPresenter by inject()
    lateinit var movieAdapter : MovieAdapter
    lateinit var mLinearLayoutManager : LinearLayoutManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        movieAdapter = MovieAdapter()
        mLinearLayoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        movie_recyclerView.apply {
            layoutManager = mLinearLayoutManager
            adapter = movieAdapter
        }

        moviePresenter.apply {
            scene = this@MovieActivity
            requestMovieData()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun addData(moive: Movie) {
        movieAdapter.apply {
            addMovieData(moive.movieList)
            notifyDataSetChanged()
        }

    }

    override fun onLoadMovieSuccess(movie: Movie) {
        addData(movie)
    }

    override fun onLoadFailed(err: String?) {
        Toast.makeText(this,"ERROR : $err ",Toast.LENGTH_LONG).show()
        Logger.e("ERROR : $err")
    }
}
