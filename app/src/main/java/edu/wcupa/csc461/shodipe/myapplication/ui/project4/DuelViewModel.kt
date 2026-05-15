package edu.wcupa.csc461.shodipe.basicstate
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import edu.wcupa.csc461.shodipe.myapplication.ui.project4.DuelMission

class DuelViewModel : ViewModel() {

    private val _missions = getDuelMissions().toMutableStateList()
    val missions: List<DuelMission> get() = _missions

    fun remove(item: DuelMission) {
        _missions.remove(item)
    }

    fun updateChecked(item: DuelMission, checked: Boolean) {
        _missions.find { it.id == item.id }?.checked = checked
    }
}

private fun getDuelMissions() = List(30) { i ->
    DuelMission(i, "GX Training Mission #$i")
}
