package com.nasahacker.promodoyou.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimerText(modifier: Modifier = Modifier, time: String) {

    Text(
        modifier = modifier.padding(8.dp),
        text = time,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 80.sp
    )

}


@Preview(showBackground = true)
@Composable
private fun PreViewTimerText() {
    TimerText(time = "25:00")
}