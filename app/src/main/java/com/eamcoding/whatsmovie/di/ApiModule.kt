package com.eamcoding.whatsmovie.di

import android.util.Log
import com.eamcoding.whatsmovie.BuildConfig
import com.eamcoding.whatsmovie.config.BASE_URL
import com.eamcoding.whatsmovie.config.CLIENT_ID
import com.eamcoding.whatsmovie.config.CLIENT_SECRET
import com.eamcoding.whatsmovie.movie.movieListModule
import com.eamcoding.whatsmovie.network.Api
import com.ihsanbal.logging.Level
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.internal.platform.Platform
import com.ihsanbal.logging.LoggingInterceptor
import org.koin.dsl.module.Module
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


val apiModule : Module = module {


    single {
        OkHttpClient.Builder().addInterceptor(
            LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .request("Request")
                .response("Response")
                .build()
        ).build()

        Retrofit.Builder()
            .client(OkHttpClient.Builder().build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(Api::class.java)
    }

}


val appModules = listOf(apiModule,movieListModule)