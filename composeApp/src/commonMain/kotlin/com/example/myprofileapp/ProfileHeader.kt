package com.example.myprofileapp

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.painterResource
import myprofileapp.composeapp.generated.resources.Res

@Composable
fun ProfileHeader(name: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        // Assuming profile.png is in commonMain/composeResources/drawable
        // If not, we might need to use a placeholder or check resource availability
        /*
        Image(
            painter = painterResource(Res.drawable.profile),
            contentDescription = "Profile",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
        */

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = name,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}