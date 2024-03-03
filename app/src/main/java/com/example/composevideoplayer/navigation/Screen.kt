package com.example.composevideoplayer.navigation

import android.net.Uri

const val VIDEO_ARGUMENT_EPISODE_URL = "episodeUrl"
const val VIDEO_ARGUMENT_TITLE = "videoTitle"

sealed class Screen(
    val route: String
) {
    object HomeScreen : Screen(route = "home")
    object VideoPlayScreen :
        Screen(route = "videoPlay/{$VIDEO_ARGUMENT_EPISODE_URL}/{$VIDEO_ARGUMENT_TITLE}") {
        fun passUrl(url: String, title: String): String {
            return "videoPlay/${Uri.encode(url)}/${title}"
        }
    }
}