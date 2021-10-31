package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
data class Note(
@PrimaryKey(autoGenerate = true)
@ColumnInfo(name = "id")
val id :Int,
@ColumnInfo(name = "noteDes")
val noteDes :String

)
