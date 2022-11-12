package com.example.interactivedictionary.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.interactivedictionary.R
import com.example.interactivedictionary.ui.theme.*


@Composable
fun WordDetailScreen(
    navHostController: NavHostController,
    word: Word
) {

    Column(
        Modifier
            .background(color = AreaColor)
            .padding(15.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                .padding(15.dp)
        ) {
            Column {
                WordNativeRow(word = word)
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                ) {
                    word.categories?.forEach { category ->
//                        DotWithWordBox(category, if (category == "home") Color.Blue else Green1)
                        ChipBox(category, LightLightBlue, Color.Blue)
                        Spacer(modifier = Modifier.width(15.dp))
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = word.wordTranslation,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fontCyrilic,
                    color = Color.Black.copy(alpha = 0.5f)
                )
                Spacer(modifier = Modifier.height(20.dp))
                word.examples?.forEach { example ->
                    WordExample(example = example, color = LightLightBlue, colorDot = Color.Blue)
                    Spacer(modifier = Modifier.height(15.dp))
                    WordExample(example = example, LighLightGreen, colorDot = Green1)

                }

            }

        }

    }
}

@Composable
fun WordNativeRow(word: Word){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = word.wordOriginal,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(20.dp))
        Box(
            modifier = Modifier
                .height(28.dp)
                .width(28.dp)

        ) {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(30.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.volume),
                    contentDescription = "", tint = Color.Blue,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                )
            }
        }
    }
}



@Composable
fun ColorDot(color: Color, topPadding: Dp) {
    Box(modifier = Modifier.padding(top = topPadding)) {
        Box(
            modifier = Modifier
                .height(6.dp)
                .width(6.dp)
                .background(color = color, shape = RoundedCornerShape(50.dp))
        ) {

        }
    }
}

@Composable
fun DotWithWordBox(text: String, color: Color) {
    Box(
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            ColorDot(color, 3.dp)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = text,
                fontWeight = FontWeight.Light,
                color = Color.Black.copy(alpha = 0.5f),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun ChipBox(text: String, colorChip: Color, colorText: Color) {
    Box(
        modifier = Modifier
//            .padding(start = 3.dp, top = 3.dp)
            .background(color = colorChip, shape = RoundedCornerShape(50.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = colorText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 2.dp)
        )
    }
}

@Composable
fun WordExample(example: WordExample, color: Color, colorDot: Color) {

    var isExpand by remember { mutableStateOf(false) }
    val rotate by animateFloatAsState(targetValue = if (isExpand) 180f else 0f)

    Box() {
        Row(
            verticalAlignment = Alignment.Top
        ) {
            ColorDot(color = colorDot, 15.dp)
            Spacer(modifier = Modifier.width(10.dp))
            Card(
                shape = RoundedCornerShape(15.dp),
                backgroundColor = color,
                elevation = 0.dp,
                modifier = Modifier
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {isExpand = !isExpand}
                    )
            ) {
                Column() {
                    Text(
                        text = example.example,
                        modifier = Modifier
                            .padding(8.dp),
                        fontWeight = FontWeight.Light,
                    )
                    AnimatedVisibility(visible = isExpand) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = example.exampleTranslation,
                            modifier = Modifier.padding(8.dp),
                            fontFamily = fontCyrilic,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Rounded.KeyboardArrowDown, "", modifier = Modifier
                            .rotate(rotate)
                            .size(16.dp))

                    }
                }
            }
        }
    }

}