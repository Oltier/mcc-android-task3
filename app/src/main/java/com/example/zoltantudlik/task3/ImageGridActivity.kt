package com.example.zoltantudlik.task3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ImageGridActivity : AppCompatActivity() {

    private lateinit var txtUrlInputField: EditText
    lateinit var sortAscButton: Button
    lateinit var sortDescButton: Button
    lateinit var sortRecentButton: Button
    lateinit var gridView: GridView

    private val imageGridController = ImageGridController()
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_grid)

        txtUrlInputField = findViewById(R.id.txtUrl)
        sortAscButton = findViewById(R.id.sortAsc)
        sortDescButton = findViewById(R.id.sortDes)
        sortRecentButton = findViewById(R.id.sortDate)
        gridView = findViewById(R.id.images)

        val keys = listOf(R.id.sortAsc, R.id.sortDes, R.id.sortDate)
        val values = listOf(sortAscButton, sortDescButton, sortRecentButton)

        val buttonMap = keys.zip(values).toMap()

        buttonMap.forEach { (id, button) ->
            button.setOnClickListener { displayImages(txtUrlInputField, id) }
        }
    }

    private fun displayImages(url: EditText, id: Int) {
        val imagesList = imageGridController.getImages(url, id)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { imagesList ->
                            Log.d("MCC", imagesList.toString())
                            imageAdapter = ImageAdapter(this, imagesList)
                            gridView.adapter = imageAdapter
                        },
                        {error -> Log.e("MCC", "Request Error", error)}
                )

    }

}
