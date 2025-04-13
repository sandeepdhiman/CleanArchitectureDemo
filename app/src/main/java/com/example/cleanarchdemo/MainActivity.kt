package com.example.cleanarchdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cleanarchdemo.presentation.NoteScreen
import com.example.cleanarchdemo.presentation.NoteViewModel
import com.example.cleanarchdemo.ui.theme.CleanArchDemoTheme
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanArchDemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("") },
                            colors = TopAppBarColors(containerColor = Color.Blue, scrolledContainerColor = Color.Blue, navigationIconContentColor = Color.White, titleContentColor = Color.White, actionIconContentColor = Color.White)
                        )
                    },
                    content = { paddingValues ->
                        val myViewModel :NoteViewModel = hiltViewModel()
                        NoteScreen(myViewModel,paddingValues)
                    }
                )

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanArchDemoTheme {
        Greeting("Android")
    }
}