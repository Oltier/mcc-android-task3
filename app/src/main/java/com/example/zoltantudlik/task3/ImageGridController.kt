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
import javax.inject.Inject


class ImageGridController {

    fun getImages(editText: EditText, sortButtonId: Int): Single<List<Image>> {
        val url = editText.text.toString()
        val gson = GsonBuilder().create()
        val okHttpClientNoCache = OkHttpClient.Builder().build()

        val imageService = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClientNoCache)
                .build()
                .create(ImageService::class.java)


        return imageService.getImages(url).map { images ->
            when(sortButtonId) {
                R.id.sortDes -> images.sortedByDescending { image -> image.author }
                R.id.sortAsc -> images.sortedBy { image -> image.author }
                R.id.sortDate -> images.sortedBy { image -> image.date }
                else -> throw Throwable("Invalid sort parameter $sortButtonId")
            }
        }
    }
}