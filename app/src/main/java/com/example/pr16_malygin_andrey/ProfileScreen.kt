package com.example.pr16_malygin_andrey

import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Preview
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(navController = rememberNavController())
}

@Composable
fun ProfileScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize().background(color = Color(0xff253334))) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp, top = 50.dp, bottom = 35.dp)) {
            Image(painter = painterResource(id = R.drawable.hamburger), contentDescription = null, modifier = Modifier.size(30.dp))
            Image(painter = painterResource(id = R.drawable.app_image), contentDescription = null, modifier = Modifier.size(65.dp))
            Text("exit", style = MaterialTheme.typography.bodyLarge, color = Color.White, modifier = Modifier.clickable { navController.navigate("main") })
        }
        Image(painter = painterResource(id = R.drawable.avatar), contentDescription = null, modifier = Modifier.size(160.dp))
        Text("Эмиль", modifier = Modifier.padding(top = 20.dp, bottom = 20.dp), style = MaterialTheme.typography.displaySmall, color = Color.White)
        Column(horizontalAlignment = Alignment.Start) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)) {
                Box {
                    Image(painter = painterResource(id = R.drawable.photo1), contentDescription = null, modifier = Modifier.width(150.dp).height(115.dp).clickable { navController.navigate("photo/photo1") })
                    Text("11:00", modifier = Modifier.padding(start = 15.dp, bottom = 18.dp).align(Alignment.BottomStart), style = MaterialTheme.typography.bodyLarge, color = Color.White)
                }
                Box {
                    Image(painter = painterResource(id = R.drawable.photo2), contentDescription = null, modifier = Modifier.width(150.dp).height(115.dp).clickable { navController.navigate("photo/photo2") })
                    Text("15:55", modifier = Modifier.padding(start = 15.dp, bottom = 18.dp).align(Alignment.BottomStart), style = MaterialTheme.typography.bodyLarge, color = Color.White)
                }
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)) {
                Box {
                    Image(painter = painterResource(id = R.drawable.photo3), contentDescription = null, modifier = Modifier.width(150.dp).height(115.dp).clickable { navController.navigate("photo/photo3") })
                    Text("19:11", modifier = Modifier.padding(start = 15.dp, bottom = 18.dp).align(Alignment.BottomStart), style = MaterialTheme.typography.bodyLarge, color = Color.White)
                }
                Box {
                    Image(painter = painterResource(id = R.drawable.photo4), contentDescription = null, modifier = Modifier.clip(RoundedCornerShape(25.dp)).width(150.dp).height(115.dp).scale(1f, 1.1f).clickable { navController.navigate("photo/photo4") })
                    Text("11:11", modifier = Modifier.padding(start = 15.dp, bottom = 18.dp).align(Alignment.BottomStart), style = MaterialTheme.typography.bodyLarge, color = Color.White)
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                OpenCamera()
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxSize().padding(start = 70.dp, end = 70.dp, bottom = 50.dp)) {
            Image(painter = painterResource(id = R.drawable.app_image), contentDescription = null, modifier = Modifier.size(35.dp).alpha(0.5f))
            Image(painter = painterResource(id = R.drawable.navigation_button), contentDescription = null, modifier = Modifier.size(25.dp))
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = null, modifier = Modifier.size(28.dp))
        }
    }
}

@Composable
fun OpenCamera() {
    val context = LocalContext.current
    val cameraPermission = android.Manifest.permission.CAMERA
    val permissionLauncher = rememberLauncherForActivityResult (
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                context.startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            } else {
                // Разрешение не предоставлено
            }
        }
    )

    Button(modifier = Modifier.padding(start = 30.dp).width(150.dp).height(115.dp), shape = RoundedCornerShape(20.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xff6AAE72)), onClick = {
        if (ContextCompat.checkSelfPermission(context, cameraPermission) != PackageManager.PERMISSION_GRANTED) {
            permissionLauncher.launch(cameraPermission)
        }
        else {
            context.startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    })
    {
        Text("+", fontSize = 25.sp)
    }
}