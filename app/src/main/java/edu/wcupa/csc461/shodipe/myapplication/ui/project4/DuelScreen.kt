package edu.wcupa.csc461.shodipe.myapplication.ui.project4
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.wcupa.csc461.shodipe.basicstate.DuelViewModel

@Composable
fun DuelScreen(
    viewModel: DuelViewModel = viewModel()
) {
    Column {
        DuelEnergyCounter()

        DuelMissionList(
            list = viewModel.missions,
            onChecked = { m, c -> viewModel.updateChecked(m, c) },
            onClose = { viewModel.remove(it) }
        )
    }
}
