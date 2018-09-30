package com.example.zoltantudlik.task3

import android.widget.EditText
import com.example.zoltantudlik.task3.rest.ImageService
import com.example.zoltantudlik.task3.rest.entities.Image
import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.URL


class ImageGridController {

    fun getImages(editText: EditText, sortButtonId: Int): Single<List<Image>> {
        val fullUrl = URL(editText.text.toString())
        val baseUrl = if(fullUrl.port != -1) "${fullUrl.protocol}://${fullUrl.host}:${fullUrl.port}/" else "${fullUrl.protocol}://${fullUrl.host}/"
        val path = fullUrl.path.drop(1)

        val gson = GsonBuilder().create()
        val okHttpClientNoCache = OkHttpClient.Builder().build()

        val imageService = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClientNoCache)
                .baseUrl(baseUrl)
                .build()
                .create(ImageService::class.java)


        return imageService.getImages(path).map { images ->
            when(sortButtonId) {
                R.id.sortDes -> images.sortedByDescending { image -> image.author }
                R.id.sortAsc -> images.sortedBy { image -> image.author }
                R.id.sortDate -> images.sortedByDescending { image -> image.date }
                else -> throw Throwable("Invalid sort parameter $sortButtonId")
            }
        }
    }
}