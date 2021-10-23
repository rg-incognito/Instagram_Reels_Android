package com.shop.instagramreels
import kotlinx.android.parcel.Parcelize

import android.os.Parcelable
@Parcelize
data class VideoItem(
    val videoUrl: String,
    val videoTitle: String,
    val VideoDes: String
):Parcelable
