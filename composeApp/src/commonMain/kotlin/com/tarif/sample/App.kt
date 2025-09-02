package com.tarif.sample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tarifchakder.ktoast.ToastDefaults
import io.github.tarifchakder.ktoast.ToastHost
import io.github.tarifchakder.ktoast.ToastState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun App() {

    val toast1 = ToastState()
    val toast2 = ToastState()

    MaterialTheme {
        Box {
            Column(Modifier.statusBarsPadding().align(Alignment.Center)) {

                Button(onClick = {
                    CoroutineScope(Dispatchers.Main).launch {
                        toast1.showToast("Hi this is a common toast")
                    }
                }) {
                    Text(
                        text = "Common TOAST"
                    )
                }

                Button(onClick = {
                    CoroutineScope(Dispatchers.Main).launch {
                        toast2.showToast("Hi this is a central toast")
                    }
                }) {
                    Text(
                        text = "Center TOAST"
                    )
                }
            }

            ToastHost(
                modifier = Modifier.fillMaxSize().padding(20.dp),
                alignment = Alignment.BottomCenter,
                hostState = toast1,
                transitionSpec = { ToastDefaults.SLIDE }
            )

            ToastHost(
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.Center,
                hostState = toast2,
                transitionSpec = { ToastDefaults.FADE }
            )
        }
    }
}