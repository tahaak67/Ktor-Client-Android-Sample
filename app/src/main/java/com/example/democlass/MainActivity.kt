package com.example.democlass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.example.democlass.presentation.ScreenOne
import com.example.democlass.ui.theme.DemoClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoClassTheme {
                Navigator(screen = ScreenOne())
            }
        }
    }
}

