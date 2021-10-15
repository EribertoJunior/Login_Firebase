package com.eriberto.loginfirebase.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

fun Application.setUpDI(){

    startKoin {
        androidContext(this@setUpDI)
        androidLogger(Level.ERROR)

        modules(listOf(appModule))
    }
}