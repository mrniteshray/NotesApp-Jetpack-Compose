package xcom.niteshray.apps.notesapp.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import xcom.niteshray.apps.notesapp.model.Note
import xcom.niteshray.apps.notesapp.ui.theme.Red
import xcom.niteshray.apps.notesapp.ui.theme.colorGrey
import xcom.niteshray.apps.notesapp.ui.theme.lightgrey
import xcom.niteshray.apps.notesapp.viewModel.NoteViewModel

@Composable
fun AddNoteScreen(noteViewModel: NoteViewModel,navController: NavHostController) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Red,
                contentColor = Color.White,
                onClick = {
                    val note = Note(0,title,description)
                    noteViewModel.insert(note)
                    navController.navigate("home")
                },
                shape = RoundedCornerShape(100.dp)

            ) {
                Icon(imageVector = Icons.Default.Done, contentDescription = "")
            }
        },
        containerColor = Color.Black
    ){ innerpading ->
        Column(
            modifier = Modifier.padding(innerpading)
        ){
            Text(text ="Add Note",
                style = MaterialTheme.typography.labelLarge,
                color = Color.White,
                fontSize = 40.sp,
                modifier = Modifier.padding(8.dp)
            )
            TextField(
                label = { Text(text="Enter Your Title", color = lightgrey) },
                value = title,
                onValueChange = {
                    title = it
                },
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                shape = RoundedCornerShape(18.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorGrey,
                    unfocusedContainerColor = colorGrey,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            TextField(
                label = { Text(text="Enter Your Description", color = lightgrey) },
                value = description,
                onValueChange = { newvalue->
                    description = newvalue
                },
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.7f).padding(16.dp),
                shape = RoundedCornerShape(18.dp),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = lightgrey,
                    unfocusedTextColor = lightgrey,
                    focusedContainerColor = colorGrey,
                    unfocusedContainerColor = colorGrey,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
    }
}