package com.example.myprofileapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myprofileapp.viewmodel.ProfileViewModel
import com.example.myprofileapp.ui.screens.*
import com.example.myprofileapp.viewmodel.NotesViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    notesViewModel: NotesViewModel,
    profileViewModel: ProfileViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Notes.route,
        modifier = modifier
    ) {
        composable(Screen.Notes.route) {
            NotesScreen(navController, notesViewModel, profileViewModel)
        }
        composable(Screen.Favorites.route) {
            FavoritesScreen(navController, notesViewModel)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(viewModel = profileViewModel)
        }
        composable(Screen.AddNote.route) {
            AddNoteScreen(navController, notesViewModel)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId") ?: 0
            NoteDetailScreen(navController, notesViewModel, noteId)
        }
        composable(
            route = Screen.Edit.route,
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId") ?: 0
            EditNoteScreen(navController, notesViewModel, noteId)
        }
    }
}
