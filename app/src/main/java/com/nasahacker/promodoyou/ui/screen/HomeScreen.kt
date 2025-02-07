package com.nasahacker.promodoyou.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nasahacker.promodoyou.R
import com.nasahacker.promodoyou.ui.component.MenuButton
import com.nasahacker.promodoyou.ui.component.StatusCard
import com.nasahacker.promodoyou.ui.component.TimerText
import com.nasahacker.promodoyou.util.MmkvManager
import com.nasahacker.promodoyou.util.PromodoTimer

@Composable
fun HomeScreen(modifier: Modifier = Modifier, controller: NavHostController) {
    var isBreak by remember { mutableStateOf(false) }
    var isPlay by remember { mutableStateOf(false) }
    var time by remember { mutableStateOf("00:25:00") }
    var type by remember { mutableStateOf("Work") }
    var promodoTimer by remember { mutableStateOf(PromodoTimer(MmkvManager.getWorkTime())) }

    LaunchedEffect(promodoTimer) {
        promodoTimer.currentTime.observeForever {
            time = it
        }
    }


    Box(modifier = modifier.fillMaxSize()) {
        StatusCard(
            modifier = Modifier
                .padding(45.dp)
                .align(Alignment.TopCenter),
            if (!isBreak) R.drawable.clock_ic else R.drawable.break_ic,
            type
        )

        TimerText(time = time, modifier = Modifier.align(Alignment.Center))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 48.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuButton(iconRes = R.drawable.settings_ic, onClick = {
                controller.navigate("settings")
            })
            MenuButton(iconRes = if (!isPlay) R.drawable.play_ic else R.drawable.pause_ic,
                onClick = {
                    isPlay = !isPlay
                    if (isPlay) {
                        promodoTimer.startTimer()
                    } else {
                        promodoTimer.pauseTimer()
                    }
                })
            MenuButton(iconRes = R.drawable.stop_ic, onClick = {
                isPlay = false
                promodoTimer.resetTimer()
            })
            MenuButton(iconRes = if (!isBreak) R.drawable.switch_right else R.drawable.switch_left,
                onClick = {
                    isBreak = !isBreak
                    isPlay = false
                    promodoTimer.resetTimer()
                    promodoTimer = if (isBreak) {
                        time = "00:${MmkvManager.getBreakTime()}:00"
                        type = "Break"
                        PromodoTimer(MmkvManager.getBreakTime())
                    } else {
                        time = "00:${MmkvManager.getWorkTime()}:00"
                        type = "Work"
                        PromodoTimer(MmkvManager.getWorkTime())
                    }
                })
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    val controller = rememberNavController()
    HomeScreen(modifier = Modifier, controller = controller)
}
