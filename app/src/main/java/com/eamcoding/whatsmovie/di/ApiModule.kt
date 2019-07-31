package com.eamcoding.whatsmovie.di

import android.util.Log
import com.eamcoding.whatsmovie.BuildConfig
import com.eamcoding.whatsmovie.config.BASE_URL
import com.eamcoding.whatsmovie.config.CLIENT_ID
import com.eamcoding.whatsmovie.config.CLIENT_SECRET
import com.eamcoding.whatsmovie.movie.movieListModule
import com.eamcoding.whatsmovie.network.Api
import com.facebook.stetho.okhttp3.StethoInterceptor
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

        val client = OkHttpClient.Builder()
            client.addInterceptor(
                LoggingInterceptor.Builder()
                    .loggable(BuildConfig.DEBUG)
                    .setLevel(Level.BASIC)
                    .log(Platform.INFO)
                    .request("OH_req")
                    .response("OH_res")
                    .build()
            )
            .addNetworkInterceptor(StethoInterceptor())
            .build()
        val okClient = client.build()


       Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okClient)
            .build()
            .create(Api::class.java)
    }

}


val appModules = listOf(apiModule,movieListModule)