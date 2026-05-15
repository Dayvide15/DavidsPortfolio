package edu.wcupa.csc461.shodipe.myapplication.ui.project2

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import edu.wcupa.csc461.shodipe.myapplication.ui.project2.theme.UnscrambleTheme

class Project2Fragment : Fragment() {

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                UnscrambleTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        GameScreen()
                    }
                }
            }
        }
    }
}