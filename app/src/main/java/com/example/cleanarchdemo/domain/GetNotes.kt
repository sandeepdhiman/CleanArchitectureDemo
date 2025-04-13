package com.example.cleanarchdemo.domain

import kotlinx.coroutines.flow.Flow

class GetNotes(private val repository: NoteRepository)  {
    operator fun invoke(): Flow<List<Note>> {
        return repository.getNotes()
    }

}