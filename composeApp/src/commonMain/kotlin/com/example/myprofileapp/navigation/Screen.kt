package com.example.myprofileapp.navigation

sealed class Screen(val route: String) {
    object Notes : Screen("notes")
    object Favorites : Screen("favorites")
    object Profile : Screen("profile")
    object AddNote : Screen("add")
    object Detail : Screen("detail/{noteId}") {
        fun createRoute(noteId: Int) = "detail/$noteId"
    }
    object Edit : Screen("edit/{noteId}") {
        fun createRoute(noteId: Int) = "edit/$noteId"
    }
}
