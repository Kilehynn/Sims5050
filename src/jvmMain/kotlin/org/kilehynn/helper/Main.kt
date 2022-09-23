// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.kilehynn.helper

import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.ScrollbarStyle
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.application
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.kilehynn.helper.utils.Root
import org.kilehynn.helper.utils.RootComponent
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.ExperimentalDecomposeApi


@OptIn(ExperimentalDecomposeApi::class)
fun main() = application {

    val lifecycle = LifecycleRegistry()
    val componentContext = DefaultComponentContext(lifecycle)
    val windowState = rememberWindowState()
    LifecycleController(lifecycle, windowState)
    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "5050 helper"
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            MaterialTheme {
                CompositionLocalProvider(
                    LocalScrollbarStyle provides ScrollbarStyle(
                        minimalHeight = 16.dp,
                        thickness = 8.dp,
                        shape = MaterialTheme.shapes.small,
                        hoverDurationMillis = 300,
                        unhoverColor = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                        hoverColor = MaterialTheme.colors.onSurface.copy(alpha = 0.50f)
                    )
                ) {
                    root(componentContext)
                }
            }
        }
    }
}


fun root(component: ComponentContext): Root =
    RootComponent(component)
