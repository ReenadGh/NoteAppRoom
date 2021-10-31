package com.example.noteroom

import android.app.Application
import androidx.lifecycle.*
import com.example.room.Note
import com.example.room.NoteDao
import com.example.room.NoteDatabase
import kotlinx.coroutines.*
import org.w3c.dom.Entity

class MyViewModel(app: Application) : AndroidViewModel(app) {
    private val repository: NoteRepository
    private val notes: LiveData<List<Note>>

    init {

        val noteDao = NoteDatabase.getDatabase(app).noteDao()
        repository = NoteRepository(noteDao)
        notes = repository.getNotes
    }

    fun getNotes(): LiveData<List<Note>> {

    return notes
    }


    fun addNote(noteText: String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addNote(Note(0, noteText))
        }
    }

    fun editNote(noteID: Int, noteText: String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.updateNote(Note(noteID,noteText))
        }
    }

    fun deleteNote(noteID: Int){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteNote(Note(noteID,""))
        }
    }

    }




