package com.example.composevideoplayer.repository

import com.example.composevideoplayer.model.Episode
import com.example.composevideoplayer.model.Video

class VideoRepository {
    fun getVideo(url: String, title: String): Video {
        val index = samplePlayList.indexOfFirst { it.url == url }
        return Video(
            title = title,
            url = url,
            episodeName = "",
            currentEpisodeIndex = index,
            episodes = samplePlayList
        )
    }
}


/**
 * Sample video from https://github.com/google/ExoPlayer/blob/release-v2/demos/cast/src/main/java/com/google/android/exoplayer2/castdemo/DemoUtil.java
 */
val samplePlayList = listOf(
    Episode(
        name = "Elephant Dream",
        url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
    ),
    Episode(
        name = "Clear HLS: Angel one",
        url = "https://storage.googleapis.com/shaka-demo-assets/angel-one-hls/hls.m3u8",
    ),
    Episode(
        name = "Clear MP4: Dizzy",
        url = "https://html5demos.com/assets/dizzy.mp4",
    )
)