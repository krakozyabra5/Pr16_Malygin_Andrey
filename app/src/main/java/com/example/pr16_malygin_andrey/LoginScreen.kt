package com.example.pr16_malygin_andrey

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(navController = rememberNavController())
}

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().background(color = Color(0xff253334))) {
        Image(painter = painterResource(id = R.drawable.app_image), contentDescription = null, modifier = Modifier.padding(start = 35.dp, top = 100.dp, bottom = 30.dp).size(65.dp))
        Text("Sign in", modifier = Modifier.padding(start = 35.dp, bottom = 110.dp), fontSize = 28.sp, color = Color.White)
        TextField(singleLine = true, modifier = Modifier.padding(start = 35.dp, end = 35.dp, bottom = 20.dp).fillMaxWidth(), colors = TextFieldDefaults.colors(unfocusedContainerColor = Color(0xff253334), focusedContainerColor = Color(0xff253334), unfocusedTextColor = Color.White, focusedTextColor = Color.White), value = email, onValueChange = { email = it }, label = { Text("Email", color = Color.Gray) })
        TextField(singleLine = true, modifier = Modifier.padding(start = 35.dp, end = 35.dp, bottom = 60.dp).fillMaxWidth(), colors = TextFieldDefaults.colors(unfocusedContainerColor = Color(0xff253334), focusedContainerColor = Color(0xff253334), unfocusedTextColor = Color.White, focusedTextColor = Color.White), value = password, onValueChange = { password = it }, label = { Text("Пароль", color = Color.Gray) }, visualTransformation = PasswordVisualTransformation())
        Button(onClick = { if (email.isNotEmpty() && password.isNotEmpty()) navController.navigate("main") }, modifier = Modifier.width(320.dp).height(60.dp).align(Alignment.CenterHorizontally), shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xff7C9A92))) {
            Text("Sign in", style = MaterialTheme.typography.titleLarge, letterSpacing = 2.sp)
        }
        Text("Register", modifier = Modifier.padding(start = 36.dp, top = 20.dp, bottom = 20.dp), textAlign = TextAlign.Start,style = MaterialTheme.typography.bodyLarge, color = Color.White)
        Button(onClick = { if (email.isNotEmpty() && password.isNotEmpty()) navController.navigate("profile") }, modifier = Modifier.width(320.dp).height(60.dp).align(Alignment.CenterHorizontally), shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xff7C9A92))) {
            Text("Профиль", style = MaterialTheme.typography.titleLarge, letterSpacing = 2.sp)
        }
    }
    Image(painter = painterResource(id = R.drawable.nature), contentDescription = null, modifier = Modifier.fillMaxSize(), alignment = Alignment.BottomCenter)
}