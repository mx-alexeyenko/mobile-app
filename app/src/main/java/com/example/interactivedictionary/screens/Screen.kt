package com.example.interactivedictionary.screens

sealed class Screen (val route: String){
    object WordList: Screen(route = "word_list_screen")
    object WordDetails: Screen(route = "word_details_screen")

//    fun withArgs(vararg args: String): String{
//        return buildString {
//            append(route)
//            args.forEach {
//                append("/$it")
//            }
//        }
//    }
}
