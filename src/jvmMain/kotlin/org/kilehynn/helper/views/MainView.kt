package views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.arkivanov.decompose.ComponentContext
import org.kilehynn.helper.utils.PathData

interface MainView{}

class MainViewComponent(private val componentContext: ComponentContext, private val path: PathData) : MainView, ComponentContext by componentContext
@Composable
fun ccValid()
{
    Button(
        contentPadding = PaddingValues(Dp(15F)),
        onClick = {
        }) {
        Text("OK")
    }
}