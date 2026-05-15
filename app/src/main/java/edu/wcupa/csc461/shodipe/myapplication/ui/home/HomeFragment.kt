package edu.wcupa.csc461.shodipe.myapplication.ui.home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Text
import edu.wcupa.csc461.shodipe.myapplication.ui.theme.MyApplicationTheme

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.context.let { context ->
            androidx.compose.ui.platform.ComposeView(context).apply {
                setContent {

                    UltimateAlienApp()
                }
            }
        }
    }
}

