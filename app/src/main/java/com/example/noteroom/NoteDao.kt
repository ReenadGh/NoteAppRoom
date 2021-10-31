package com.example.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNote(note : Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query("SELECT * FROM Note ORDER BY id ASC  ")
    fun getAllNote(): LiveData<List<Note>>
}