package com.example.zoltantudlik.task3

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.lang.Exception


class TextViewTarget(private val textView: TextView): Target {

    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
        textView.setCompoundDrawables(null, BitmapDrawable(textView.resources, bitmap), null, null)
    }
}