package views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.arkivanov.decompose.ComponentContext
import org.kilehynn.helper.utils.MODS_PATH
import java.awt.Component
import java.io.File
import javax.swing.JFileChooser
import javax.swing.UIManager

interface WelcomeView {
    fun selectFile(path: String, window: Component): File?;

    fun onPathChoosed(path: String);

}

class WelcomeViewComponent(
    private val componentContext: ComponentContext,
    private val onFileChoosed: (path: String) -> Unit
) :
    ComponentContext by componentContext, WelcomeView {
    override fun selectFile(path: String, window: Component): File? {
        var result: File? = null
        val systemLookAndFeel = UIManager.getSystemLookAndFeelClassName()
        val lookAndFeel = if (systemLookAndFeel == "javax.swing.plaf.metal.MetalLookAndFeel") "com.sun.java.swing.plaf.gtk.GTKLookAndFeel" else systemLookAndFeel;
        UIManager.setLookAndFeel(lookAndFeel)
        val fileChooser =
            JFileChooser(path, null).apply {
                fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
                isMultiSelectionEnabled = false
                dialogType = JFileChooser.OPEN_DIALOG
                dialogTitle = "Select folder to scan"
                selectedFile = File(path)

                addActionListener {
                    if (it.actionCommand == JFileChooser.APPROVE_SELECTION) {
                        result = (it.source as JFileChooser).selectedFile
                        (it.source as JFileChooser).isVisible = false
                    }
                }
            }
        fileChooser.showDialog(window, "Select")

        return result
    }

    override fun onPathChoosed(path: String) {
        onPathChoosed(path)
    }

    @Composable
    public fun welcome(window: Component, file: String) {
        Column(
            modifier = Modifier.padding(PaddingValues(Dp(60F))),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, content = {
                Text("Hi, I'm 50-50 Helper!\nI'm sorry your mods broke with the last update but we are going to fix it\n")
                Button(
                    contentPadding = PaddingValues(Dp(15F)), onClick = {
                        val res = selectFile(MODS_PATH, window)
                        onPathChoosed(res?.absolutePath ?: "")
                    }) {
                    Text("Select files to scan")
                }
            })
    }


}


