package com.example.myprofileapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myprofileapp.navigation.Screen
import com.example.myprofileapp.ui.components.NoteCard
import com.example.myprofileapp.viewmodel.NotesViewModel

@Composable
fun FavoritesScreen(
    navController: NavController,
    viewModel: NotesViewModel
) {
    val notes by viewModel.notes.collectAsState()
    val favoriteNotes = notes.filter { it.isFavorite }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            
            Text(
                text = "Favorites",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            
            Text(
                text = "You have ${favoriteNotes.size} favorite notes",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            if (favoriteNotes.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No favorite notes yet",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f)
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 100.dp)
                ) {
                    items(favoriteNotes) { note ->
                        NoteCard(
                            note = note,
                            onClick = {
                                navController.navigate(Screen.Detail.createRoute(note.id))
                            },
                            onFavoriteClick = {
                                viewModel.toggleFavorite(note.id)
                            }
                        )
                    }
                }
            }
        }
    }
}
