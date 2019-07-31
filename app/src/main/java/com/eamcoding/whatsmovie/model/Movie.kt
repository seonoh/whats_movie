package com.eamcoding.whatsmovie.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("lastBuildDate")
    val lastBuildDate : String,
    @SerializedName("total")
    val total : Int,
    @SerializedName("start")
    val start : Int,
    @SerializedName("display")
    val display : Int,

    @SerializedName("items")
    val movieList : ArrayList<MovieItem>

){
    data class MovieItem(
        @SerializedName("title")
        var title : String,
        @SerializedName("link")
        val link : String,
        @SerializedName("image")
        val image : String,
        @SerializedName("subtitle")
        val subTitle : String,
        @SerializedName("pubDate")
        val pubDate : String,
        @SerializedName("director")
        var director : String,
        @SerializedName("actor")
        var actor : String,
        @SerializedName("userRating")
        val userRating : Double
    )
}