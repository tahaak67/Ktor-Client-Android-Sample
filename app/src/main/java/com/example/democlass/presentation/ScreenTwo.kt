package com.example.democlass.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class ScreenTwo() : Screen {

    @Composable
    override fun Content() {
        ScreenTwoContent()
    }
}

@Composable
fun ScreenTwoContent(modifier: Modifier = Modifier) {
    val navigator = LocalNavigator.currentOrThrow
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Screen 2", fontSize = 45.sp)
        Button(onClick = { navigator.pop() }) {
            Text(text = "Go Back")
        }
    }
}
