package org.kilehynn.helper.utils

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import views.MainViewComponent
import views.WelcomeViewComponent
import java.io.File


interface Root {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class Welcome(val component: WelcomeViewComponent) : Child()
        class Main(val component: MainViewComponent) : Child()
    }
}


class RootComponent(
    componentContext: ComponentContext, // In Decompose each component has its own ComponentContext
) : ComponentContext by componentContext, Root {


    private val navigation = StackNavigation<Config>()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.Welcome,
            handleBackButton = true, // Pop the back stack on back button press
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, Root.Child>> get() = stack

    private fun createChild(config: Config, componentContext: ComponentContext): Root.Child =
        when (config) {
            is Config.Welcome -> Root.Child.Welcome(welcome(componentContext))
            is Config.Main -> Root.Child.Main(main(componentContext, config))
        }
// Configurations are handled exhaustively


    private fun welcome(componentContext: ComponentContext): WelcomeViewComponent =
        WelcomeViewComponent(
            componentContext = componentContext,
            onFileChoosed = { navigation.push(Config.Main(pathData = PathData(File(it)))) }
        )

    private fun main(componentContext: ComponentContext, config: Config.Main): MainViewComponent =
        MainViewComponent(
            componentContext = componentContext,
            path = config.pathData)


    sealed class Config : Parcelable {
        @Parcelize
        object Welcome : Config()
        @Parcelize
        data class Main(val pathData: PathData) : Config()
    }
}

