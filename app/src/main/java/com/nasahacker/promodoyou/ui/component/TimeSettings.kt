package com.nasahacker.promodoyou.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nasahacker.promodoyou.R

@Composable
fun TimeSettings(
    modifier: Modifier = Modifier,
    label: String,
    value: Long,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = label)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            MenuButton(modifier = Modifier.clip(CircleShape),
                iconRes = R.drawable.baseline_remove_24,
                onClick = { onDecrement() })
            Text(
                text = "$value Minutes",
                fontSize = 22.sp,
                modifier = Modifier.align(Alignment.CenterVertically),
                fontWeight = FontWeight.Medium
            )
            MenuButton(modifier = Modifier.clip(CircleShape),
                iconRes = R.drawable.baseline_add_24,
                onClick = { onIncrement() })

        }

        HorizontalDivider(modifier.padding(top = 8.dp))


    }


}


@Preview(showBackground = true)
@Composable
private fun PreviewTimeSettings() {
    TimeSettings(label = "Work Time", value = 5, onIncrement = {}, onDecrement = {})
}