package com.example.interactivedictionary

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import androidx.navigation.compose.composable
import com.example.interactivedictionary.screens.Screen
import com.example.interactivedictionary.screens.Word
import com.example.interactivedictionary.screens.WordDetailScreen
import com.example.interactivedictionary.screens.WordListScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
//import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController




@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.WordList.route,
//        enterTransition = { _, _ ->
//            slideInHorizontally(
//                initialOffsetX = { width -> 2 * width },
//                animationSpec = tween(1000)
//            )
//        },
//        exitTransition = { _, _ ->
//            slideOutHorizontally(
//                targetOffsetX = { width -> -2 * width },
//                animationSpec = tween(1000)
//            )
//        }
    ) {
        composable(
            route = Screen.WordList.route,

            ) {
            WordListScreen(navController)
        }

        composable(
            route = Screen.WordDetails.route,
        ) {
            val word =
                navController.previousBackStackEntry?.savedStateHandle?.get<Word>("word")

            word?.let {
                WordDetailScreen(navController, word)
            }
        }
    }
}