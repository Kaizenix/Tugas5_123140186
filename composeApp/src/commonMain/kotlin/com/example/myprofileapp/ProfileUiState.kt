package com.example.myprofileapp

data class ProfileUiState(
    val name: String = "Muhamad Arif Ardani",
    val bio: String = "Mahasiswa Teknik Informatika ITERA",
    val email: String = "arifardani819@email.com",
    val phone: String = "081271782507",
    val location: String = "Lampung",
    val following: String = "123",
    val followers: String = "140k",
    val likes: String = "186k",
    val isFollowing: Boolean = false,
    val isDarkMode: Boolean = false,
    val isEditing: Boolean = false
)