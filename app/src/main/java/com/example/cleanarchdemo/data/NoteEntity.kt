package com.example.cleanarchdemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleanarchdemo.domain.Note

@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String,
    val content:String
){
    fun toDomain(): Note = Note(id, title, content)
}
fun Note.toEntity(): NoteEntity = NoteEntity(id, title, content)
