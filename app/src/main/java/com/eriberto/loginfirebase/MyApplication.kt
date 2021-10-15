package com.eriberto.loginfirebase

import android.app.Application
import com.eriberto.loginfirebase.di.setUpDI

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpDI()
    }
}