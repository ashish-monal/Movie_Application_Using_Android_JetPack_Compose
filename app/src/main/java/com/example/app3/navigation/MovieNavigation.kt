package com.example.app3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app3.screens.home.HomeScreen
import com.example.app3.screens.details.DetailsScreen

@Composable
fun MoviesNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name)
    {
        composable(MovieScreens.HomeScreen.name)
        {
            // Here we pass where this should lead us to
            HomeScreen(navController = navController)
        }
        //www.google.com/details-screen/id=34
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie")
            { type = NavType.StringType }))
        {

            backStackEntry ->
            DetailsScreen(navController = navController,backStackEntry.arguments?.getString("movie"))
        }
    }
}