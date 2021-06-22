package com.example.laboratory

import android.app.Application
import com.example.laboratory.data.source.TasksRepository
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application() {

    val taskRepository: TasksRepository
        get() = ServiceLocator.provideTasksRepository(this)

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
    }
}