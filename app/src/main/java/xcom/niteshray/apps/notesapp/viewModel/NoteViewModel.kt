package xcom.niteshray.apps.notesapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import xcom.niteshray.apps.notesapp.db.NotesDao
import xcom.niteshray.apps.notesapp.model.Note

class NoteViewModel(noteDao : NotesDao): ViewModel() {
    val _NotesList = MutableLiveData<List<Note>>()
    val NoteList : LiveData<List<Note>> get() = _NotesList
    val noteDao = noteDao

    init {
        fetchNote()
    }
    fun insert(note : Note){
        viewModelScope.launch(Dispatchers.IO) {
            noteDao.insert(note)
            fetchNote()
        }
    }

    fun update(note : Note){
        viewModelScope.launch(Dispatchers.IO){
            noteDao.update(note)
            fetchNote()
        }
    }

    fun delete(note : Note){
        viewModelScope.launch(Dispatchers.IO) {
            noteDao.delete(note)
            val updatedList = noteDao.fetchNotes()
            _NotesList.postValue(updatedList)
        }
    }

    fun fetchNote(){
        viewModelScope.launch(Dispatchers.IO){
            val list = noteDao.fetchNotes()
            _NotesList.postValue(list)
        }
    }
}