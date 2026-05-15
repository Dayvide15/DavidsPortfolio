package edu.wcupa.csc461.shodipe.myapplication.ui.project3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment

class Project3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                DessertClickerApp()
            }
        }
    }
}


@Composable
fun DessertClickerApp() {

    var experimentsRun by remember { mutableStateOf(0) }
    var energyUnits by remember { mutableStateOf(0) }

    val maxEnergy = 100
    val energyPercent = (energyUnits.coerceAtMost(maxEnergy)).toFloat() / maxEnergy

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "🧪 CHAOS LAB TERMINAL",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Experiments completed: $experimentsRun")
        Text(text = "Energy output: $energyUnits ⚡")

        Spacer(modifier = Modifier.height(20.dp))

        // Energy bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .padding(horizontal = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(energyPercent)
                    .fillMaxHeight()
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                experimentsRun++
                energyUnits += 10
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("⚡ RUN EXPERIMENT")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                experimentsRun = 0
                energyUnits = 0
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🧼 RESET LAB")
        }
    }
}