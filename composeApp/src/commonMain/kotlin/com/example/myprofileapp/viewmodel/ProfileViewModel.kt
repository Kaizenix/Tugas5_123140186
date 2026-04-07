package com.example.myprofileapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ProfileUiState(
    val name: String = "Muhamad Arif Ardani",
    val bio: String = "Mahasiswa Teknik Informatika ITERA",
    val email: String = "arifardani819@email.com",
    val phone: String = "081271782507",
    val location: String = "Lampung",
//    val following: String = "123",
//    val followers: String = "140k",
//    val likes: String = "186k",
    val isFollowing: Boolean = false,
    val isDarkMode: Boolean = false,
    val isEditing: Boolean = false
)

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun toggleFollow() {
        _uiState.update { it.copy(isFollowing = !it.isFollowing) }
    }

    fun toggleDarkMode() {
        _uiState.update { it.copy(isDarkMode = !it.isDarkMode) }
    }

    fun toggleEditMode() {
        _uiState.update { it.copy(isEditing = !it.isEditing) }
    }

    fun updateName(newName: String) {
        _uiState.update { it.copy(name = newName) }
    }

    fun updateBio(newBio: String) {
        _uiState.update { it.copy(bio = newBio) }
    }
}
