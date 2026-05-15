package edu.wcupa.csc461.shodipe.myapplication.ui.project4
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DuelMissionItem(
    missionName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier.weight(1f),
                text = missionName
            )

            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange
            )

            IconButton(onClick = onClose) {
                Icon(Icons.Filled.Close, contentDescription = "Discard Mission")
            }
        }
    }
}
