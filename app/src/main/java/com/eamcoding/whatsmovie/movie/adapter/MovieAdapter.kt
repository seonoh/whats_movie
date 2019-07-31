package com.eamcoding.whatsmovie.movie.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.eamcoding.whatsmovie.R
import com.eamcoding.whatsmovie.model.Movie
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.regex.Pattern

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    lateinit var  mMovieData : ArrayList<Movie.MovieItem>
    lateinit var mView : View

    fun addMovieData(data : ArrayList<Movie.MovieItem>){
        if(!::mMovieData.isInitialized){
            mMovieData = data
        }else{
            mMovieData.addAll(data)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        mView = LayoutInflater.from(parent!!.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return if(::mMovieData.isInitialized) mMovieData.size else 0
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item =  mMovieData[position]

        if(item.image.isNullOrEmpty() || item.title.isNullOrEmpty() || item.director.isNullOrEmpty() || item.actor.isNullOrEmpty()){

            holder.itemView.visibility = View.GONE

        }else{
            holder.itemView.visibility = View.VISIBLE
        }



        if ( holder is MovieViewHolder){

                holder.bindMovieData(mMovieData,position)

        }
    }

    inner class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindMovieData( movieItem : ArrayList<Movie.MovieItem>, position: Int ){
            val item =  movieItem[position]

            with(itemView){


                Glide.with(itemView.context).load(item.image)
                    .thumbnail(0.05f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(movie_imv)

                Logger.e("change title : ${item.title}")
                movie_title_value_tv.text = item.title
                movie_director_value_tv.text = item.director
                movie_actor_value_tv.text = item.actor
                movie_user_rating_valuetv.text = item.userRating.toString()

            }

        }


    }
}

