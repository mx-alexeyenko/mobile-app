package com.example.interactivedictionary.screens

import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.interactivedictionary.WordCard
import com.example.interactivedictionary.ui.theme.AreaColor
import kotlinx.parcelize.Parcelize

@Parcelize
data class Word(
    val wordOriginal: String,
    val wordTranslation: String,
    val categories: List<String>? = null,
    val examples: List<WordExample>? = null

) : Parcelable

@Parcelize
data class WordExample(
    val example: String,
    val exampleTranslation: String
) : Parcelable

val listOfWords = listOf(
    Word(
        "Whether", "Погода",
        categories = listOf("home", "whether"),
        examples = listOf(
            WordExample(
                "To set padding for Text composable, in Android Jetpack Compose, assign modifier parameter of Text with Modifier companion",
                "Компонент IconButton представляет кликабельную иконку, по нажатию на которую можно выполнить некоторые действия. То есть, фактически он "
            )
        )
    ),
    Word("Typography", "Типография"),
    Word("Something strange", "Что-то странное"),
    Word("Smart", "Умный"),
    Word("Soft sofa", "Мягкий диван"),
    Word("Whether", "Погода"),
    Word("Typography", "Типография"),
    Word("Something strange", "Что-то странное"),
    Word("Smart", "Умный"),
    Word("Soft sofa", "Мягкий диван"),
    Word("Whether", "Погода"),
    Word("Typography", "Типография"),
    Word("Something strange", "Что-то странное"),
    Word("Smart", "Умный"),
    Word("Soft sofa", "Мягкий диван"),
    Word("Whether", "Погода"),
    Word("Typography", "Типография"),
    Word("Something strange", "Что-то странное"),
    Word("Smart", "Умный"),
    Word("Soft sofa", "Мягкий диван"),
    Word("Whether", "Погода"),
    Word("Typography", "Типография"),
    Word("Something strange", "Что-то странное"),
    Word("Smart", "Умный"),
    Word("Soft sofa", "Мягкий диван"),
)


@Composable
fun WordListScreen(
    navController: NavHostController
) {
    LazyColumn(
        modifier =
        Modifier
            .fillMaxSize()
            .background(color = AreaColor)
    ) {

        itemsIndexed(listOfWords) { _, word ->
            WordCard(navController, word)

        }
    }
}