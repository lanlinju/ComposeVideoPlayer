package com.example.composevideoplayer

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.composevideoplayer.model.Video
import com.example.composevideoplayer.navigation.VIDEO_ARGUMENT_EPISODE_URL
import com.example.composevideoplayer.navigation.VIDEO_ARGUMENT_TITLE
import com.example.composevideoplayer.repository.VideoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class VideoPlayViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val repository: VideoRepository = VideoRepository()
    private val _videoState: MutableStateFlow<Resource<Video?>> =
        MutableStateFlow(value = Resource.Loading())
    val videoState: StateFlow<Resource<Video?>>
        get() = _videoState


    lateinit var videoTitle: String

    init {
        savedStateHandle.get<String>(key = VIDEO_ARGUMENT_TITLE)?.let { title ->
            videoTitle = title
        }
        savedStateHandle.get<String>(key = VIDEO_ARGUMENT_EPISODE_URL)?.let { episodeUrl ->
            val url = Uri.decode(episodeUrl)
            getVideo(url, videoTitle)
        }
    }

    fun getVideo(url: String, title: String) {
        _videoState.value = Resource.Success(repository.getVideo(url = url, title = title))
    }

}