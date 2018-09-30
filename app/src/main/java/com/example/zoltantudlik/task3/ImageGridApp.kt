package com.example.zoltantudlik.task3

import android.app.Application
import com.example.zoltantudlik.task3.dagger.components.NetworkComponent
import com.example.zoltantudlik.task3.dagger.modules.AppModule
import com.example.zoltantudlik.task3.dagger.components.*


class ImageGridApp : Application() {
    companion object {
        @JvmStatic lateinit var networkComponent: NetworkComponent
    }

    override fun onCreate() {
        super.onCreate()

        val appModule = AppModule(this)
        val applicationComponent = DaggerApplicationComponent.builder()
                .appModule(appModule)
                .build()

        networkComponent = DaggerNetworkComponent
                .builder()
                .applicationComponent(applicationComponent)
                .build()
    }
}