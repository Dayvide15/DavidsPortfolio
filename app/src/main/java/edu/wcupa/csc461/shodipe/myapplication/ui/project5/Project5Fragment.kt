package edu.wcupa.csc461.shodipe.myapplication.ui.project5

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import edu.wcupa.csc461.shodipe.businesscard.ui.theme.BusinesscardTheme

class Project5Fragment : Fragment() {

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                BusinesscardTheme {
                    BusinessCard()
                }
            }
        }
    }
}