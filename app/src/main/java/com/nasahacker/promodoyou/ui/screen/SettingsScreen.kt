package com.nasahacker.promodoyou.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nasahacker.promodoyou.ui.component.TimeSettings
import com.nasahacker.promodoyou.util.MmkvManager
import com.tencent.mmkv.MMKV

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(controller: NavHostController) {

    var breakTime by remember { mutableLongStateOf(MmkvManager.getBreakTime()) }
    var workTime by remember { mutableLongStateOf(MmkvManager.getWorkTime()) }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Settings") }, navigationIcon = {
            IconButton(onClick = {
                controller.popBackStack()
            }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        })
    }) { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding)) {


            TimeSettings(label = "Work Time", value = workTime, onIncrement = {
                workTime = MmkvManager.incrementWorkTime()
            }, onDecrement = {
                workTime = MmkvManager.decrementWorkTime()
            })
            TimeSettings(
                label = "Break Time",
                value = breakTime,
                onIncrement = {
                    breakTime = MmkvManager.incrementBreakTime()
                },
                onDecrement = {
                    breakTime = MmkvManager.decrementBreakTime()
                })


        }

    }

}


@Preview
@Composable
private fun PreviewSettingsScreen() {
    SettingsScreen(
        controller = rememberNavController()
    )
}