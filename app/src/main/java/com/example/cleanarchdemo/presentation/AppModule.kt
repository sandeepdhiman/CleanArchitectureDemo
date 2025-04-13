package com.example.cleanarchdemo.presentation

import android.content.Context
import androidx.room.Room
import com.example.cleanarchdemo.data.NoteDatabase
import com.example.cleanarchdemo.data.NoteRepositoryImpl
import com.example.cleanarchdemo.domain.DeleteNotes
import com.example.cleanarchdemo.domain.GetNotes
import com.example.cleanarchdemo.domain.InsertNotes
import com.example.cleanarchdemo.domain.NoteRepository
import com.example.cleanarchdemo.domain.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun NoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao())

    }

    @Provides
    fun provideUseCases(repository: NoteRepository): NoteUseCases =
        NoteUseCases(
            getNotes = GetNotes(repository),
            insertNote = InsertNotes(repository),
            deleteNote = DeleteNotes(repository)
        )

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(context, NoteDatabase::class.java, "notes_db").build()
}