package com.pptg.emeasure.ui

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import org.greenrobot.eventbus.EventBus

class EMApplication():Application() {
    companion object {
        private const val TAG = "EMApplication"
        // 全局 context
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}