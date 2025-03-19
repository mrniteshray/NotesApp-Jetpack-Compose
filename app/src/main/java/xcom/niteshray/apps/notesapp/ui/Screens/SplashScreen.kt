package xcom.niteshray.apps.notesapp.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController){
    Scaffold(
        containerColor = Color.Black
    ){ innerpadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerpadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text(text = "Notes App",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        LaunchedEffect(Unit) {
            delay(2000)
            navController.navigate("home")
        }
    }
}