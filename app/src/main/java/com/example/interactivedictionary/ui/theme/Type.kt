package com.example.interactivedictionary.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.interactivedictionary.R

// Set of Material typography styles to start with

val fontDefault = FontFamily(
        Font(R.font.outfit_medium, weight = FontWeight.Medium),
        Font(R.font.outfit_regular, weight= FontWeight.Normal),
        Font(R.font.outfit_thin, weight= FontWeight.Thin),
        Font(R.font.outfit_light, weight= FontWeight.Light),
        Font(R.font.outfit_extralight, weight= FontWeight.ExtraLight),
        )

val fontCyrilic = FontFamily(
        Font(R.font.raleway_medium, weight = FontWeight.Medium),
        Font(R.font.raleway_regular, weight= FontWeight.Normal),
        Font(R.font.raleway_thin, weight= FontWeight.Thin),
        Font(R.font.raleway_light, weight= FontWeight.Light),
)

val Typography = Typography(
        defaultFontFamily= fontDefault,
        body1 = TextStyle(
//                fontFamily = FontFamily.Default,
//                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        )
        /* Other default text styles to override
    button = TextStyle(        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
