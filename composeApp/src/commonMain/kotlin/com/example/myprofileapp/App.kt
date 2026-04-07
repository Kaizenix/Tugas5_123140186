package com.example.myprofileapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.myprofileapp.navigation.NavGraph
import com.example.myprofileapp.ui.components.BottomNavBar
import com.example.myprofileapp.ui.theme.NotesAppTheme
import com.example.myprofileapp.viewmodel.NotesViewModel
import com.example.myprofileapp.viewmodel.ProfileViewModel as ProfileVm

@Composable
fun App() {
    val notesViewModel: NotesViewModel = viewModel { NotesViewModel() }
    val profileViewModel: ProfileVm = viewModel { ProfileVm() }
    val profileUiState by profileViewModel.uiState.collectAsState()
    val navController = rememberNavController()

    NotesAppTheme(darkTheme = profileUiState.isDarkMode) {
        // Menggunakan Box agar BottomNavBar bisa melayang di atas NavGraph
        Box(modifier = Modifier.fillMaxSize()) {
            NavGraph(
                navController = navController,
                notesViewModel = notesViewModel,
                profileViewModel = profileViewModel,
                modifier = Modifier.fillMaxSize()
            )
            
            // Letakkan BottomNavBar di bagian bawah
            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                BottomNavBar(navController = navController)
            }
        }
    }
}
