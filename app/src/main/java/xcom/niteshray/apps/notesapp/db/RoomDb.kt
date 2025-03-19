package xcom.niteshray.apps.notesapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import xcom.niteshray.apps.notesapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class RoomDb : RoomDatabase() {

    abstract fun NoteDao() : NotesDao

    companion object{
        @Volatile
        private var INSTANCE: RoomDb? = null

        fun getDatabase(context: Context): RoomDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDb::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}