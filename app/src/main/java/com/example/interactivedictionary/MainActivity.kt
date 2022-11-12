package com.example.interactivedictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.interactivedictionary.ui.theme.InteractiveDictionaryTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {


    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InteractiveDictionaryTheme {
                
//                navController = rememberAnimatedNavController()
                Navigation()
//
//                Column(
//                    modifier = Modifier.background(color = AreaColor)
//                ) {
//                    WordCard()
//                }
            }
        }
    }
}