package com.pixel.todoCompose.presentation.activities.home.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pixel.todoCompose.R
import com.pixel.todoCompose.presentation.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(
    title: String,
    onSideMenuClick: () -> Unit,
) {
    MediumTopAppBar(
        colors =
            TopAppBarDefaults
                .topAppBarColors(
                    containerColor = Primary,
                    titleContentColor = Color.White,
                ),
        title = {
            Text(
                text = title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    onSideMenuClick()
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = stringResource(R.string.des_navigation_icon),
                    tint = Color.White,
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = stringResource(R.string.des_add_new_task_icon),
                    tint = Color.White,
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = stringResource(R.string.des_add_new_task_icon),
                    modifier = Modifier.background(Color.White, shape = RoundedCornerShape(6.dp)),
                    tint = Primary,
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun AppBarPreview() {
    HomeAppBar(title = "ToDo Home") {
    }
}
