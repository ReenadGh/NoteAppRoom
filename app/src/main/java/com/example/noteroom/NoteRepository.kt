package com.example.noteroom

import androidx.lifecycle.LiveData
import com.example.room.Note
import com.example.room.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

    val getNotes: LiveData<List<Note>> = noteDao.getAllNote()

    suspend fun addNote(note: Note){
        noteDao.insertNote(note)
    }

    suspend fun updateNote(note: Note){
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note){
        noteDao.delete(note)
    }

}