package xcom.niteshray.apps.notesapp.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import xcom.niteshray.apps.notesapp.model.Note
import xcom.niteshray.apps.notesapp.ui.theme.Red
import xcom.niteshray.apps.notesapp.ui.theme.colorBlack
import xcom.niteshray.apps.notesapp.ui.theme.colorGrey
import xcom.niteshray.apps.notesapp.viewModel.NoteViewModel

@Composable
fun HomeScreen(viewModel: NoteViewModel, navController: NavHostController) {
    val notes by viewModel.NoteList.observeAsState(initial = emptyList())
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("addNote")
            } ,
                contentColor = Color.White,
                containerColor = Red,
                shape = RoundedCornerShape(100.dp)
            ) { Icon(imageVector = Icons.Default.Add, contentDescription = "")}
        },
        containerColor = colorBlack
    ){ innerpadding ->
        Column(
            modifier = Modifier.padding(innerpadding)
        ){
            Text(text="Notes App",
                style = MaterialTheme.typography.labelLarge,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
                )
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(
            ){
                items(notes) {
                    NotesListItems(it)
                }
            }
        }
    }
}

@Composable
fun NotesListItemsPreview(){
    val note = Note(1,"Sample Title","this is an sample text of notes")
    NotesListItems(note)
}

@Composable
fun NotesListItems(note : Note){
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(colorGrey)

    ){
        Column(
            modifier = Modifier.padding(12.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = note.title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "",
                    tint = Color.White,
                )
            }
            Text(text = note.description,
                color = Color.White,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 18.sp
            )
        }
    }
}