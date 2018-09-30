package com.example.zoltantudlik.task3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.zoltantudlik.task3.rest.entities.Image
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_entry.view.*

class ImageAdapter(var context: Context, foodsList: List<Image>) : BaseAdapter() {

    private var imageList: List<Image> = foodsList

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val image = this.imageList[position]
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val imageView = inflater.inflate(R.layout.image_entry, parent, false)
        Picasso.get().load(image.photo).into(imageView.displayImage)
        imageView.imageTitle.text = image.author

        return imageView
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