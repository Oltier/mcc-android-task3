package com.example.zoltantudlik.task3.dagger.components

import android.app.Application
import com.example.zoltantudlik.task3.dagger.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
interface ApplicationComponent {
    fun getApplication(): Application
}