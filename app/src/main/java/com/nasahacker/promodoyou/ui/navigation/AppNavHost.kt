package com.nasahacker.promodoyou.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nasahacker.promodoyou.ui.screen.HomeScreen
import com.nasahacker.promodoyou.ui.screen.SettingsScreen

@Composable
fun AppNavHost(modifier: Modifier, controller: NavHostController) {

    NavHost(controller, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(modifier = modifier, controller = controller)
        }
        composable(route = "settings") {
            SettingsScreen(controller = controller)
        }
    }


}