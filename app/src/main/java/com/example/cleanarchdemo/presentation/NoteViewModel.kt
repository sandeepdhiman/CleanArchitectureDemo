package com.example.cleanarchdemo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchdemo.domain.Note
import com.example.cleanarchdemo.domain.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(private val noteUseCases: NoteUseCases) : ViewModel() {

    val notes = noteUseCases.getNotes().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun insertNote(note: Note) {
        viewModelScope.launch {
            noteUseCases.insertNote(note)
        }

    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteUseCases.deleteNote(note)
        }
    }
}