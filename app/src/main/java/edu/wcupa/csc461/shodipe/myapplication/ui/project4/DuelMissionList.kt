package edu.wcupa.csc461.shodipe.myapplication.ui.project4
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DuelMissionList(
    list: List<DuelMission>,
    onChecked: (DuelMission, Boolean) -> Unit,
    onClose: (DuelMission) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(list, key = { it.id }) { mission ->
            DuelMissionItem(
                missionName = mission.label,
                checked = mission.checked,
                onCheckedChange = { onChecked(mission, it) },
                onClose = { onClose(mission) }
            )
        }
    }
}