package com.example.composevideoplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.composevideoplayer.navigation.Screen
import com.example.composevideoplayer.navigation.VideoNavHost
import com.example.composevideoplayer.ui.theme.ComposeVideoPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeVideoPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    VideoNavHost(
                        navController = navController,
                        onNavigationToVideoPlay = { url, title ->
                            navController.navigate(Screen.VideoPlayScreen.passUrl(url, title))
                        },
                        onBackClick = { navController.popBackStack() },
                        activity = this
                    )
                }
            }
        }
    }
}

