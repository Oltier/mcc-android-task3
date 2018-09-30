package com.example.zoltantudlik.task3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.zoltantudlik.task3.rest.entities.Image
import com.squareup.picasso.Picasso

class ImageAdapter(var context: Context, foodsList: List<Image>) : BaseAdapter() {

    private var imageList: List<Image> = foodsList

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val image = this.imageList[position]
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val textView = inflater.inflate(R.layout.image_entry, parent, false) as TextView
        val textViewTarget = TextViewTarget(textView)
        Picasso.get().load(image.photo).into(textViewTarget)
        textView.text = image.author

        return textView
    }

    override fun getItem(position: Int): Any {
        return imageList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return imageList.size
    }
}