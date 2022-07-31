// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import views.welcome
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import utils.THEME_COLORS

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}


fun main() = application {
    Window(
        title = "50-50 Helper",
        state = rememberWindowState(width = Dp.Unspecified, height = Dp.Unspecified),
        onCloseRequest = ::exitApplication
    )
    {
        val window = this.window
        var file by remember { mutableStateOf("") }

        var theme = MaterialTheme(
            colors = THEME_COLORS
        ) {
            Column(
                content = {
                    welcome(window, file) { file = it }
                }, modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            )
        }
    }
}

//colors = Colors(
//primary = Color(0xb8d14a),
//primaryVariant = Color(0x66bb46),
//secondary = Color(0x299ed9),
//secondaryVariant = Color(0x315dab),
//background = Color(0xffffff),
//surface = Color(0xb8d14a),
//error = Color(0xf44336),
//onSurface = Color(0x000000),
//onBackground = Color(0xb8d14a),
//onError = Color(0x000000),
//onPrimary = Color(0x000000),
//onSecondary = Color(0x000000),
//isLight = true
//),
