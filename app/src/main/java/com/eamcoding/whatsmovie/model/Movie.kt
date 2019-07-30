package com.eamcoding.whatsmovie.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("items")
    val movieList : MovieItem

){
    data class MovieItem(
        @SerializedName("title")
        val movieTitle : String
    )
}