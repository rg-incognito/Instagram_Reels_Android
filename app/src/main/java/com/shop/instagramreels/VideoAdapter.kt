package com.shop.instagramreels

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.core.view.doOnDetach
import androidx.recyclerview.widget.RecyclerView
import com.danikula.videocache.HttpProxyCacheServer


class VideoAdapter(
    val videoList:ArrayList<VideoItem>,
    val context: Context
): RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {



    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val videoView = itemView.findViewById<VideoView>(R.id.videoview)
        val videoTitle :TextView = itemView.findViewById(R.id.textVideoTitle)
        val videoDes :TextView = itemView.findViewById(R.id.textVideodes)
        val progressBar:ProgressBar= itemView.findViewById(R.id.videoProgressBar)

        val proxy= HttpProxyCacheServer(videoView.context)

        fun setVideoData(videoItem: VideoItem){
            videoTitle.text = videoItem.videoTitle
            videoDes.text = videoItem.VideoDes
            val proxyUrl = proxy.getProxyUrl(videoItem.videoUrl)
            videoView.setVideoPath(proxyUrl)

//            videoView.setVideoURI(Uri.parse(videoItem.videoUrl))
            videoView.setOnPreparedListener {
                    progressBar.visibility = View.GONE
                    it.start()

                val videoRatio = it.videoWidth / it.videoHeight.toFloat()
                val screenratio = videoView.width / videoView.height.toFloat()
                val scale :Float = videoRatio/screenratio
                if (scale >= 1f){
                    videoView.scaleX = scale
                }else
                    videoView.scaleY = scale

            }
            videoView.setOnCompletionListener {
                it.start()
            }
            videoView.doOnDetach {
                proxy.shutdown()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
       return VideoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_container_video,parent,false))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.setVideoData(videoList.get(position))

    }

    override fun getItemCount(): Int {
        return videoList.size
    }

   


}