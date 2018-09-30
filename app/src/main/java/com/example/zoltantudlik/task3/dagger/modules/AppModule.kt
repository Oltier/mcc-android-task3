package com.example.zoltantudlik.task3.dagger.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    fun providesApplication(): Application {
        return application
    }

}