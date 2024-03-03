package com.example.composevideoplayer.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composevideoplayer.HomeScreen
import com.example.composevideoplayer.VideoPlayScreen

@Composable
fun VideoNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Screen.HomeScreen.route,
    onNavigationToVideoPlay: (String, String) -> Unit,
    onBackClick: () -> Unit,
    activity: Activity
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(onNavigationToVideoPlay = onNavigationToVideoPlay)
        }

        composable(Screen.VideoPlayScreen.route) {
            VideoPlayScreen(activity = activity, onBackClick = onBackClick)
        }

    }
}