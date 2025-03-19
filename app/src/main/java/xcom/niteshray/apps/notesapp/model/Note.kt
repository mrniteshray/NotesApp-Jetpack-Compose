package xcom.niteshray.apps.notesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val title : String,
    val description : String
)