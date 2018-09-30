package com.example.zoltantudlik.task3.rest.entities

import org.joda.time.DateTime
import java.util.*


data class Image(
        val photo: String,
        val author: String,
        val date: Date
)