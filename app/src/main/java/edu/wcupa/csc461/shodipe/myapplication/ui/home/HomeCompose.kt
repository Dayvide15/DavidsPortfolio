package edu.wcupa.csc461.shodipe.myapplication.ui.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun UltimateAlienApp(modifier: Modifier = Modifier) {
    var showOnboarding by rememberSaveable { mutableStateOf(true) }


        if (showOnboarding) {
            OnboardingScreen(onContinueClicked = { showOnboarding = false })
        } else {
            UltimateAlienRoster()
        }

}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "Ultimate Alien Omnitrix",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked,
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text("Open Roster", color = Color.White)
            }
        }

}

data class UltimateAlien(
    val name: String,
    val species: String,
    val powers: String
)

@Composable
private fun UltimateAlienRoster(
    modifier: Modifier = Modifier
) {
    val aliens = listOf(
        UltimateAlien("Ultimate Humungousaur", "Vaxasaurian", "Missile launchers, immense strength, armor"),
        UltimateAlien("Ultimate Swampfire", "Methanosian", "Blue fire blasts, plant/element control, durability"),
        UltimateAlien("Ultimate Echo Echo", "Sonorosian", "Sonic technology, sound blasts"),
        UltimateAlien("Ultimate Spidermonkey", "Arachnichimp", "Enhanced strength, agility, climbing"),
        UltimateAlien("Ultimate Big Chill", "Necrofriggian", "Ice and flame manipulation, intangibility, flight"),
        UltimateAlien("Ultimate Cannonbolt", "Arburian Pelarota", "Armored rolling attack, spikes"),
        UltimateAlien("Ultimate Wildmutt", "Vulpimancer", "Enhanced senses, agility, feral strength"),
        UltimateAlien("Ultimate Way Big", "To'kustar", "Gigantic size, cosmic beams, flight"),

        // New aliens
        UltimateAlien("Ra’ad", "Unknown Species", "Electrical attacks, high speed"),
        UltimateAlien("NRG", "Protostar", "Energy blasts, radiation manipulation, flight"),
        UltimateAlien("Fast Track", "Cheetor-like Alien", "Super speed, agility"),
        UltimateAlien("Ultimate Fourarms", "Tetramand", "Super strength, four arms, combat skill"),
        UltimateAlien("Water Hydra", "Hydran", "Multiple heads, water control, regeneration"),
        UltimateAlien("Torospin", "Toroid Alien", "Spinning attacks, rolling damage, high defense")
    )

    val expandedStates = remember { mutableStateMapOf<String, Boolean>() }

    LazyColumn(
        modifier = modifier
            .padding(vertical = 4.dp)
            .background(Color.Black)
    ) {
        items(aliens) { alien ->
            val expanded = expandedStates.getOrDefault(alien.name, false)
            UltimateAlienCard(
                alien = alien,
                expanded = expanded,
                onExpandChanged = { expandedStates[alien.name] = it }
            )
        }
    }
}

@Composable
private fun UltimateAlienCard(
    alien: UltimateAlien,
    expanded: Boolean,
    onExpandChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val cardGreen = Color(0xFF004225) // Uniform green color for all cards

    Surface(
        color = cardGreen,
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 4.dp,
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = alien.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
                if (expanded) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Species: ${alien.species}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Powers: ${alien.powers}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            ElevatedButton(
                onClick = { onExpandChanged(!expanded) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(if (expanded) "Hide" else "Details", color = Color.White)
            }
        }
    }
}
