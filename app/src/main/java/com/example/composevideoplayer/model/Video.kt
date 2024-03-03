package com.example.composevideoplayer.model

data class Video(
    val title: String,
    val url: String,
    val episodeName: String,
    val currentEpisodeIndex: Int = 0,
    val episodes: List<Episode>
)
