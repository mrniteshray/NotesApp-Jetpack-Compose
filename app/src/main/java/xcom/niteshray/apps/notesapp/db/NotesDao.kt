package xcom.niteshray.apps.notesapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import xcom.niteshray.apps.notesapp.model.Note

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : Note)

    @Update
    suspend fun update(note : Note)

    @Delete
    suspend fun delete(note : Note)

    @Query("Select * From Notes")
    suspend fun fetchNotes() : List<Note>
}