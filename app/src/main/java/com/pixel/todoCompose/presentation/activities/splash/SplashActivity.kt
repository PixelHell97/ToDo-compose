package com.pixel.todoCompose.presentation.activities.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pixel.todoCompose.R
import com.pixel.todoCompose.presentation.activities.home.MainActivity
import com.pixel.todoCompose.presentation.theme.Primary
import com.pixel.todoCompose.presentation.theme.SplashBackground
import com.pixel.todoCompose.presentation.theme.Typography

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    private val postDelay: Long = 3000 // 3 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle =
                SystemBarStyle.light(
                    scrim = Color.TRANSPARENT,
                    darkScrim = Color.TRANSPARENT,
                ),
            navigationBarStyle =
                SystemBarStyle.light(
                    scrim = Color.TRANSPARENT,
                    darkScrim = Color.TRANSPARENT,
                ),
        )
        setContent {
            SplashView()
            Handler(mainLooper).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, postDelay)
        }
    }
}

@Composable
fun SplashView() {
    Column(
        modifier = Modifier.fillMaxSize().background(SplashBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1F))
        Image(
            painter =
                painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.des_app_logo),
        )
        Spacer(modifier = Modifier.weight(1F))
        Text(
            text = "supervised by PixelHell97",
            color = Primary,
            style = Typography.titleSmall,
            modifier = Modifier.padding(16.dp),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, apiLevel = 33)
@Composable
private fun SplashScreenPreview() {
    SplashView()
}
