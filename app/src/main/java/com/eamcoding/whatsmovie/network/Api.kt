package com.eamcoding.whatsmovie.network

import com.eamcoding.whatsmovie.model.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {

    @GET("movie.json")
    fun getMovieInfo(@HeaderMap  map : Map<String,String>
                     ,@Query("query") searchText : String
                     ,@Query("display") display : Int
                    ): Single<Movie>
}