package org.kilehynn.helper.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font


val THEME_COLORS = Colors(
    primary = Color(0xb8, 0xd1, 0x4a),
    primaryVariant = Color(0x66, 0xbb, 0x46),
    secondary = Color(0x29, 0x9e, 0xd9),
    secondaryVariant = Color(0x31, 0x5d, 0xab),
    background = Color(0xff, 0xff, 0xff),
    surface = Color(0xb8, 0xd1, 0x4a),
    error = Color(0xf4, 0x43, 0x36),
    onSurface = Color(0x00, 0x00, 0x00),
    onBackground = Color(0x00, 0x00, 0x4a),
    onError = Color(0x00, 0x00, 0x00),
    onPrimary = Color(0x00, 0x00, 0x00),
    onSecondary = Color(0x00, 0x00, 0x00),
    isLight = true
)
val primary = Color(48, 163, 230)
val secondary = Color(24, 25, 29)


@Composable
fun HelperExampleTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = THEME_COLORS,
        typography = Typography(
            defaultFontFamily = FontFamily(Font("google_sans_regular.ttf"))
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            content()
        }
    }
}