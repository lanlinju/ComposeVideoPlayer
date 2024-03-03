package com.example.composevideoplayer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composevideoplayer.repository.samplePlayList

@Composable
fun HomeScreen(
    onNavigationToVideoPlay: (url: String, title: String) -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {
        samplePlayList.forEach {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = { onNavigationToVideoPlay(it.url, it.name) }
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = it.name)
                }
            }
        }
    }

}