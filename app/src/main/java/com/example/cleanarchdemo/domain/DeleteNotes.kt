package com.example.cleanarchdemo.domain

class DeleteNotes(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }

}