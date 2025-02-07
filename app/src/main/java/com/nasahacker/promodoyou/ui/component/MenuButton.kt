package com.nasahacker.promodoyou.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasahacker.promodoyou.R

/**
 * @author Tamim Hossain
 * Contact: tamimh.dev@gmail.com
 * Copyright: 2025
 */

@Composable
fun MenuButton(
    modifier: Modifier = Modifier,
    iconRes: Int,
    onClick: () -> Unit
) {
    Card(
        onClick = {
            onClick()
        },
        modifier = modifier.clip(RoundedCornerShape(18.dp))
        ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.padding(18.dp)
        )
    }


}


@Preview(showBackground = true)
@Composable
private fun PreviewMenuButton() {
    MenuButton(iconRes = R.drawable.settings_ic, onClick = {

    })
}