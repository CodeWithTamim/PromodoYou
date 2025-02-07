package com.nasahacker.promodoyou.ui.screen

import android.graphics.Paint.Align
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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

/**
 * @author Tamim Hossain
 * Contact: tamimh.dev@gmail.com
 * Copyright: 2025
 */
@Composable
fun HomeScreen(modifier: Modifier = Modifier, controller: NavHostController) {

    var isBreak by remember { mutableStateOf(false) }
    var isPlay by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        StatusCard(
            modifier = Modifier
                .padding(45.dp)
                .align(Alignment.TopCenter),
            R.drawable.clock_ic,
            "Work"
        )


        TimerText(time = "25:00", modifier = Modifier.align(Alignment.Center))


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
            MenuButton(
                iconRes = if (!isPlay) R.drawable.play_ic else R.drawable.pause_ic,
                onClick = { isPlay = !isPlay })
            MenuButton(iconRes = R.drawable.stop_ic, onClick = {})

            MenuButton(
                iconRes = if (!isBreak) R.drawable.switch_right else R.drawable.switch_left,
                onClick = { isBreak = !isBreak })

        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    val controller = rememberNavController()
    HomeScreen(modifier = Modifier, controller = controller)
}