package xcom.niteshray.apps.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import xcom.niteshray.apps.notesapp.db.RoomDb
import xcom.niteshray.apps.notesapp.model.Note
import xcom.niteshray.apps.notesapp.ui.Screens.AddNoteScreen
import xcom.niteshray.apps.notesapp.ui.Screens.HomeScreen
import xcom.niteshray.apps.notesapp.ui.Screens.SplashScreen
import xcom.niteshray.apps.notesapp.ui.Screens.UpdateNoteScreen
import xcom.niteshray.apps.notesapp.ui.theme.NotesAppTheme
import xcom.niteshray.apps.notesapp.viewModel.NoteViewModel
import xcom.niteshray.apps.notesapp.viewModel.NoteViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val database = RoomDb.getDatabase(this)
            val factory = NoteViewModelFactory(database.NoteDao())
            val noteViewModel : NoteViewModel = viewModel(factory = factory)
            var noteid = 0
            NotesAppTheme {
                NavHost(navController , startDestination = "splash"){
                    composable("splash") {
                        SplashScreen(navController)
                    }
                    composable("home") {
                        HomeScreen(noteViewModel,navController){
                            noteid = it.id
                            navController.navigate("update")
                        }
                    }
                    composable("addNote") {
                        AddNoteScreen(noteViewModel,navController)
                    }
                    composable("update") {
                        UpdateNoteScreen(noteid, noteViewModel , navController)
                    }
                }
            }
        }
    }
}
