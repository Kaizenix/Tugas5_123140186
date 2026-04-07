package com.example.myprofileapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.myprofileapp.data.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NotesViewModel : ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(dummyNotes)
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    fun addNote(title: String, content: String, isFavorite: Boolean) {
        val newNote = Note(
            id = if (_notes.value.isEmpty()) 1 else _notes.value.maxOf { it.id } + 1,
            title = title,
            content = content,
            isFavorite = isFavorite,
            createdAt = "Today" // Simplified for now
        )
        _notes.update { it + newNote }
    }

    fun updateNote(id: Int, title: String, content: String, isFavorite: Boolean) {
        _notes.update { currentNotes ->
            currentNotes.map {
                if (it.id == id) it.copy(title = title, content = content, isFavorite = isFavorite)
                else it
            }
        }
    }

    fun deleteNote(id: Int) {
        _notes.update { currentNotes ->
            currentNotes.filter { it.id != id }
        }
    }

    fun toggleFavorite(id: Int) {
        _notes.update { currentNotes ->
            currentNotes.map {
                if (it.id == id) it.copy(isFavorite = !it.isFavorite)
                else it
            }
        }
    }

    fun getNoteById(id: Int): Note? {
        return _notes.value.find { it.id == id }
    }
}

val dummyNotes = listOf(
    Note(1, "Beli Susu", "Beli susu di minimarket dekat rumah", false, "22 Oct"),
    Note(2, "Tugas PAM", "Selesaikan tugas pertemuan 5 navigasi", true, "21 Oct"),
    Note(3, "Meeting", "Meeting project jam 10 pagi", false, "20 Oct"),
    Note(4, "Ide Project", "Aplikasi pencatat keuangan personal", true, "19 Oct")
)
