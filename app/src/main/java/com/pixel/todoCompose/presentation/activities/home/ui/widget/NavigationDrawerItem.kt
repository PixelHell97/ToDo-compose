package com.pixel.todoCompose.presentation.activities.home.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pixel.todoCompose.presentation.theme.Primary
import com.pixel.todoCompose.presentation.theme.TaupeGray
import com.pixel.todoCompose.presentation.theme.Typography

@Composable
fun NavigationDrawerItem(
    itemName: String,
    itemColor: Color,
    numberOfTask: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 8.dp).fillMaxWidth(),
    ) {
        Spacer(
            modifier =
                Modifier
                    .padding(8.dp)
                    .background(itemColor)
                    .padding(6.dp),
        )
        Text(text = itemName, style = Typography.labelSmall, color = itemColor)

        Text(
            text = numberOfTask,
            modifier = Modifier.padding(end = 16.dp).fillMaxWidth(),
            textAlign = TextAlign.End,
            color = TaupeGray,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemPreview() {
    Column {
        NavigationDrawerItem(itemName = "Home", itemColor = Primary, numberOfTask = "0")
        NavigationDrawerItem(itemName = "Home", itemColor = Primary, numberOfTask = "0")
        NavigationDrawerItem(itemName = "Home", itemColor = Primary, numberOfTask = "0")
    }
}
