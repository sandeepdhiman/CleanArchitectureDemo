package com.example.cleanarchdemo.domain

class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNotes,
    val insertNote: InsertNotes
)
