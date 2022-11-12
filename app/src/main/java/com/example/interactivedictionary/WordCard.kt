package com.example.interactivedictionary

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.interactivedictionary.screens.Screen
import com.example.interactivedictionary.screens.Word

@Composable
fun WordCard(
    navController: NavHostController,
    word: Word
) {
    Box(
        modifier = Modifier
            .height(70.dp)
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .background(
                color = Color.White, shape = RoundedCornerShape(15.dp)
            )
            .clip(RoundedCornerShape(15.dp))
            .clipToBounds()
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("word", word)
                navController.navigate(route = Screen.WordDetails.route)
            }
            .fillMaxWidth()
    )
    {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(start = 15.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = word.wordOriginal,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = word.wordTranslation,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}
