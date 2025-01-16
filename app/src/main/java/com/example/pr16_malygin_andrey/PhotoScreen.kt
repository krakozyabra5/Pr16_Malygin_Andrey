package com.example.pr16_malygin_andrey

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PreviewPhotoScreen() {
    PhotoScreen(navController = rememberNavController())
}

@Composable
fun PhotoScreen(navController: NavController, image: String = "photo4") {
    val imageResId = LocalContext.current.resources.getIdentifier(image, "drawable", LocalContext.current.packageName)
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier
        .fillMaxSize()
        .background(Color(0xff253334))) {
        Image(painter = painterResource(id = imageResId), contentDescription = null, modifier = Modifier
            .heightIn(max = 750.dp)
            .fillMaxSize())
        Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp))
        {
            TextButton(onClick = { }) { Text("удалить", style = MaterialTheme.typography.bodyLarge, color = Color.White) }
            TextButton(onClick = { navController.popBackStack() }) { Text("закрыть", style = MaterialTheme.typography.bodyLarge, color = Color.White) }
        }
    }
}

