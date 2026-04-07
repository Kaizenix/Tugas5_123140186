package com.example.myprofileapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun App() {
    val profileViewModel: ProfileViewModel = viewModel { ProfileViewModel() }
    ProfileScreen(viewModel = profileViewModel)
}