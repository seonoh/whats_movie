package com.eamcoding.whatsmovie

import android.app.Application
import com.eamcoding.whatsmovie.di.appModules
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.koin.android.ext.android.startKoin


class WhatMovieApplication : Application(){


    override fun onCreate() {
        super.onCreate()

        startKoin(this, appModules)
        Logger.addLogAdapter(AndroidLogAdapter())

    }
}