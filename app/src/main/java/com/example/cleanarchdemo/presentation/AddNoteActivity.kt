package com.example.cleanarchdemo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cleanarchdemo.domain.Note
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class AddNoteActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("") },
                        navigationIcon =  {
                            IconButton(onClick = { finish() }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Menu")
                            }
                        },
                        colors = TopAppBarColors(containerColor = Color.Blue, scrolledContainerColor = Color.Blue, navigationIconContentColor = Color.White, titleContentColor = Color.White, actionIconContentColor = Color.White)
                    )
                },
                content = { paddingValues ->
                    val myViewModel :NoteViewModel = hiltViewModel()
                    AddUser(myViewModel,paddingValues)
                }
            )

        }}

    @Composable
    fun AddUser(viewModel: NoteViewModel = viewModel(),modifier: PaddingValues){
        Column(Modifier.fillMaxWidth().padding(modifier),
            horizontalAlignment = Alignment.CenterHorizontally) {
            var name by remember{mutableStateOf("")}
            var mobile by remember {
                mutableStateOf("")
            }
            OutlinedTextField(value =name, onValueChange ={name =it},
                modifier = Modifier.fillMaxWidth().padding(15.dp),
                label = { Text(text = "Title")})

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value =mobile, onValueChange ={mobile =it},
                modifier = Modifier.fillMaxWidth().padding(15.dp),
                label = { Text(text = "Content")})

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(onClick = {
                viewModel.insertNote(Note(title = name, content = mobile))
                name =""
                mobile =""
            },
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RectangleShape,
                border= BorderStroke(1.dp, Color.Blue),
                contentPadding = PaddingValues(0.dp),  //avoid the little icon
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Blue, contentColor =  Color.Blue)
            ) {
                Text(text = "AddUser",color = Color.White)
            }
        }
    }

}