package com.example.zoltantudlik.task3.rest

import com.example.zoltantudlik.task3.rest.entities.Image
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url


interface ImageService {
    @GET
    fun getImages(@Url path: String): Single<List<Image>>
}