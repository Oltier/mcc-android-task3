package com.example.zoltantudlik.task3.dagger.components

import com.example.zoltantudlik.task3.ImageGridActivity
import com.example.zoltantudlik.task3.dagger.modules.AppModule
import com.example.zoltantudlik.task3.dagger.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class], dependencies = [ApplicationComponent::class])
interface NetworkComponent {
    fun inject(activity: ImageGridActivity)
}