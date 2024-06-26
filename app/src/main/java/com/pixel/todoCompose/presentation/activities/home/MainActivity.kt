package com.pixel.todoCompose.presentation.activities.home

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pixel.todoCompose.presentation.activities.home.ui.widget.HomeNavigationDrawer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle =
                SystemBarStyle.light(
                    Color.TRANSPARENT,
                    Color.TRANSPARENT,
                ),
            navigationBarStyle =
                SystemBarStyle.light(
                    Color.TRANSPARENT,
                    Color.TRANSPARENT,
                ),
        )
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    HomeNavigationDrawer()
}

@Preview(showBackground = true, showSystemUi = true, apiLevel = 33)
@Composable
private fun HomePreview() {
    HomeScreen()
}
