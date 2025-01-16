package com.example.pr16_malygin_andrey

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PreviewOnboardingScreen() {
    OnboardingScreen(navController = rememberNavController())
}

@Composable
fun OnboardingScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.background), contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillHeight)
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.app_image), contentDescription = null, modifier = Modifier.padding(top = 40.dp).size(280.dp))
            Text("Привет", style = MaterialTheme.typography.displayMedium, color = Color.White, modifier = Modifier.padding(bottom = 5.dp))
            Text("Наслаждайся отборочными.", style = MaterialTheme.typography.bodyLarge, color = Color.White)
            Text("Будь внимателен.", style = MaterialTheme.typography.bodyLarge, color = Color.White)
            Text("Делай хорошо.", style = MaterialTheme.typography.bodyLarge, color = Color.White)

            Button(modifier = Modifier.offset(0.dp, 100.dp).width(320.dp).height(60.dp), onClick = { navController.navigate("login") }, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xff7C9A92))) {
                Text("Войти в аккаунт", style = MaterialTheme.typography.titleLarge)
            }
            Text("Ещё нет аккаунта? Зарегистрируйтесь", modifier = Modifier.offset(0.dp, 100.dp).padding(bottom = 80.dp,top = 15.dp), style = MaterialTheme.typography.bodyLarge, color = Color.White)
        }
    }
}
