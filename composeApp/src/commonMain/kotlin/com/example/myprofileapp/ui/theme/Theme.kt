package com.example.myprofileapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryGreenDark,
    secondary = OliveGreen,
    background = DarkBackground,
    surface = DarkCard,
    onPrimary = Color.White,
    onBackground = PrimaryTextDark,
    onSurface = PrimaryTextDark,
    secondaryContainer = SecondaryDark,
    onSecondaryContainer = PrimaryTextDark
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryGreen,
    secondary = OliveGreen,
    background = LightBackground,
    surface = LightCard,
    onPrimary = Color.White,
    onBackground = PrimaryTextLight,
    onSurface = PrimaryTextLight,
    secondaryContainer = SoftGreen,
    onSecondaryContainer = PrimaryTextLight
)

@Composable
fun NotesAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
