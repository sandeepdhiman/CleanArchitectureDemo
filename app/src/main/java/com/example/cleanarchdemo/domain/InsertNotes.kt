package com.example.cleanarchdemo.domain

class InsertNotes(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.insertNote(note)
    }
}