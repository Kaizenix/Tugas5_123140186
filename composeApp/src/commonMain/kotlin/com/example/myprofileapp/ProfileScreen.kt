package com.example.myprofileapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import myprofileapp.composeapp.generated.resources.Res
import myprofileapp.composeapp.generated.resources.*

@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    
    // Warna tema adaptif (Dark Mode)
    val primaryColor = if (uiState.isDarkMode) Color(0xFF81C784) else Color(0xFF427A43)
    val backgroundColor = if (uiState.isDarkMode) Color(0xFF121212) else Color.White
    val cardColor = if (uiState.isDarkMode) Color(0xFF1E1E1E) else Color.White
    val textColor = if (uiState.isDarkMode) Color.White else Color.Black
    val secondaryColor = Color(0xFFF2E3BB)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryColor)
    ) {
        // --- HEADER SECTION ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 60.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Profile\nInformation",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    lineHeight = 38.sp
                )
                
                // Dark Mode Toggle
                IconButton(onClick = { viewModel.toggleDarkMode() }) {
                    Icon(
                        imageVector = if (uiState.isDarkMode) Icons.Default.LightMode else Icons.Default.DarkMode,
                        contentDescription = "Toggle Dark Mode",
                        tint = Color.White
                    )
                }
            }
        }

        // --- CONTENT SECTION ---
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 220.dp),
            color = backgroundColor,
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .padding(top = 60.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                if (uiState.isEditing) {
                    // --- EDIT MODE ---
                    Text("Edit Profile", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = textColor)
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    ProfileTextField(
                        label = "Name",
                        value = uiState.name,
                        onValueChange = { viewModel.updateName(it) }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    ProfileTextField(
                        label = "Bio",
                        value = uiState.bio,
                        onValueChange = { viewModel.updateBio(it) }
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { viewModel.toggleEditMode() },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text("Save Changes", color = Color.White)
                    }
                } else {
                    // --- DISPLAY MODE ---
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = primaryColor.copy(alpha = 0.1f),
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(Icons.Default.Person, null, tint = primaryColor, modifier = Modifier.padding(12.dp))
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text("Name", color = Color.Gray, fontSize = 14.sp)
                                Text(uiState.name, fontWeight = FontWeight.SemiBold, color = textColor)
                            }
                        }
                        IconButton(onClick = { viewModel.toggleEditMode() }) {
                            Icon(Icons.Default.Edit, "Edit", tint = primaryColor)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Text(text = uiState.bio, color = Color.Gray, lineHeight = 22.sp, fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(32.dp))

                    Text("Contact Info", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = textColor)
                    Spacer(modifier = Modifier.height(16.dp))

                    InfoFileItem(Icons.Default.Email, "Email", uiState.email, primaryColor, cardColor, textColor)
                    InfoFileItem(Icons.Default.Phone, "Phone", uiState.phone, primaryColor, cardColor, textColor)
                    InfoFileItem(Icons.Default.LocationOn, "Location", uiState.location, primaryColor, cardColor, textColor)

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { viewModel.toggleFollow() },
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (uiState.isFollowing) Color.Gray else primaryColor
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(if (uiState.isFollowing) "Following" else "Follow", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
            }
        }

        // --- FLOATING STATS & IMAGE ROW ---
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 220.dp).offset(y = (-40).dp).padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.height(85.dp).weight(1f, fill = false),
                shape = RoundedCornerShape(20.dp),
                shadowElevation = 8.dp,
                color = cardColor
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StatItem(uiState.following, "Following", primaryColor)
                    Box(modifier = Modifier.width(1.dp).height(24.dp).background(Color.LightGray))
                    StatItem(uiState.followers, "Followers", primaryColor)
                    Box(modifier = Modifier.width(1.dp).height(24.dp).background(Color.LightGray))
                    StatItem(uiState.likes, "Likes", primaryColor)
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Box(modifier = Modifier.size(85.dp).shadow(10.dp, CircleShape).clip(CircleShape).background(secondaryColor)) {
                Image(
                    painter = painterResource(Res.drawable.pp),
                    contentDescription = "Profile Photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun StatItem(count: String, label: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(count, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = color)
        Text(label, fontSize = 10.sp, color = Color.Gray)
    }
}

@Composable
fun InfoFileItem(icon: ImageVector, title: String, subtitle: String, themeColor: Color, cardColor: Color, textColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).shadow(4.dp, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Surface(shape = CircleShape, color = themeColor.copy(alpha = 0.1f), modifier = Modifier.size(40.dp)) {
                Icon(icon, null, tint = themeColor, modifier = Modifier.padding(10.dp))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = textColor)
                Text(subtitle, color = Color.Gray, fontSize = 13.sp)
            }
        }
    }
}