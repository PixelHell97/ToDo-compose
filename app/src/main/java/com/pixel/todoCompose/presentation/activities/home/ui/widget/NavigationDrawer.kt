package com.pixel.todoCompose.presentation.activities.home.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.pixel.todoCompose.R
import com.pixel.todoCompose.presentation.theme.BitterSweet
import com.pixel.todoCompose.presentation.theme.ColumbiaBlue
import com.pixel.todoCompose.presentation.theme.FadedGray
import com.pixel.todoCompose.presentation.theme.Jonquil
import com.pixel.todoCompose.presentation.theme.Primary
import com.pixel.todoCompose.presentation.theme.Typography
import kotlinx.coroutines.launch

@Composable
fun HomeNavigationDrawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navController = rememberNavController()

    ModalNavigationDrawer(drawerContent = { HomeNavigationDrawerSheet() }) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                HomeAppBar(title = "Home Screen") {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            },
        ) { innerPadding ->
            Text(text = "Hello World!", modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun HomeNavigationDrawerSheet() {
    ModalDrawerSheet(modifier = Modifier.fillMaxWidth(0.65F)) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1F)
                    .background(Primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Keep awake!!",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
            )
        }
        Text(
            text = "Categories",
            modifier = Modifier.padding(16.dp),
            style = Typography.labelLarge,
        )
        Spacer(
            modifier =
                Modifier
                    .padding(end = 16.dp)
                    .background(FadedGray)
                    .fillMaxWidth()
                    .padding(0.3.dp),
        )

        NavigationDrawerItem(
            itemName = stringResource(R.string.all_tasks),
            itemColor = ColumbiaBlue,
            numberOfTask = "0",
        )

        NavigationDrawerItem(
            itemName = stringResource(R.string.home_page),
            itemColor = Jonquil,
            numberOfTask = "0",
        )
        NavigationDrawerItem(
            itemName = stringResource(R.string.home_page),
            itemColor = BitterSweet,
            numberOfTask = "0",
        )
        Spacer(
            modifier =
                Modifier
                    .padding(top = 64.dp)
                    .fillMaxWidth(),
        )
        ExtendedFloatingActionButton(
            text = { Text("New category", color = Primary) },
            icon = { Icon(Icons.Filled.Add, contentDescription = "", tint = Primary) },
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(start = 8.dp),
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DrawerSheetPrev() {
    HomeNavigationDrawerSheet()
}

@Preview(apiLevel = 33, showSystemUi = true, showBackground = true)
@Composable
private fun NavPreview() {
    HomeNavigationDrawer()
}
