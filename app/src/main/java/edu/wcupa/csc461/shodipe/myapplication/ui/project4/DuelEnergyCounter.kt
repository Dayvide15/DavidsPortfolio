package edu.wcupa.csc461.shodipe.myapplication.ui.project4
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DuelEnergyCounter(modifier: Modifier = Modifier) {
    var lp by rememberSaveable { mutableStateOf(0) }

    Column(modifier = modifier.padding(16.dp)) {

        if (lp > 0) {
            Text("⚡ Duel Energy: $lp LP")
        }

        Row(modifier = Modifier.padding(top = 8.dp)) {

            Button(onClick = { lp++ }, enabled = lp < 10) {
                Text("Power Up (+1 LP)")
            }

            Button(
                onClick = { lp = 0 },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Reset Duel")
            }
        }
    }
}
