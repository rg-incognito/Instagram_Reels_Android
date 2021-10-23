package com.shop.instagramreels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    lateinit var  viewPager2:ViewPager2
    val videolist:ArrayList<VideoItem> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2 = findViewById(R.id.videoViewPager)

            val videoItem1 = VideoItem(
            "https://a.tmp.ninja/kVsBuUrk.mp4",
                "Video1",
                "nsdvsn"
            )
        val videoItem2 = VideoItem(
            "https://a.tmp.ninja/rjOwQbb.mp4",
                "Video2",
                "jnkfjnkjw"
            )
        val videoItem3 = VideoItem(
            "https://a.tmp.ninja/BHDbDNB.mp4",
                "Video3",
                "wjenfjnkje"
            )
        val videoItem4 = VideoItem(
            "https://a.tmp.ninja/BHDbDNB.mp4",
                "Video4",
                "ksmadlkkjsn"
            )
        val videoItem5 = VideoItem(
            "https://a.tmp.ninja/BHDbDNB.mp4",
                "Video5",
                "snfvjn"
            )

        videolist.add(videoItem1)
        videolist.add(videoItem2)
        videolist.add(videoItem3)
        videolist.add(videoItem4)
        videolist.add(videoItem5)

        viewPager2.adapter = VideoAdapter(videolist,this)








    }
}