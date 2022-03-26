package com.example.libraryappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.libraryappui.ui.screens.MainScreen
import com.example.libraryappui.ui.theme.LibraryAppUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryAppUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
//                    modifier = Modifier
//                        .fillMaxSize()
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    MainScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LibraryAppUITheme {
        MainApp()
    }
}