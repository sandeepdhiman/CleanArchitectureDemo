package com.example.cleanarchdemo.data

import com.example.cleanarchdemo.domain.Note
import com.example.cleanarchdemo.domain.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> =
        noteDao.getNotes().map { it.map { entity -> entity.toDomain() } }

    override suspend fun insertNote(note: Note) {
       noteDao.insertNote(note.toEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toEntity())
    }
}