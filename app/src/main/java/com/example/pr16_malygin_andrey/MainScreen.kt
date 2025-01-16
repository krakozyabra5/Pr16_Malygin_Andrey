package com.example.pr16_malygin_andrey

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen(navController = rememberNavController())
}

@Composable
fun MainScreen(navController: NavController, onViewDetailsClick: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize().background(color = Color(0xff253334))) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 20.dp, top = 50.dp, bottom = 35.dp)) {
            Image(painter = painterResource(id = R.drawable.hamburger), contentDescription = null, modifier = Modifier.size(30.dp))
            Image(painter = painterResource(id = R.drawable.app_image), contentDescription = null, modifier = Modifier.size(65.dp).offset(x = 6.dp, y = 0.dp))
            Image(painter = painterResource(id = R.drawable.avatar), contentDescription = null, modifier = Modifier.size(45.dp).clickable { navController.navigate("profile") }
            )
        }
        Text("С возвращением, Эмиль!", modifier = Modifier.padding(start = 25.dp, bottom = 10.dp), fontSize = 28.sp, color = Color.White)
        Text("Каким ты себя ощущаешь сегодня?", modifier = Modifier.padding(start = 25.dp, bottom = 10.dp), style = MaterialTheme.typography.bodyLarge, color = Color.White.copy(alpha = 0.7f))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)) {
            Image(painter = painterResource(id = R.drawable.calm_mood), contentDescription = null, modifier = Modifier.size(80.dp))
            Image(painter = painterResource(id = R.drawable.relax_mood), contentDescription = null, modifier = Modifier.size(80.dp))
            Image(painter = painterResource(id = R.drawable.focus_mood), contentDescription = null, modifier = Modifier.size(80.dp))
            Image(painter = painterResource(id = R.drawable.anxious), contentDescription = null, modifier = Modifier.size(80.dp))
        }
        Row(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp).clip(RoundedCornerShape(15.dp)).background(Color.White)) {
            Column {
                Text("Заголовок блока", modifier = Modifier.padding(start = 25.dp, top = 25.dp, bottom = 5.dp), fontSize = 25.sp, color = Color.Black, fontWeight = FontWeight.Normal)
                Text("Кратенькое описание блока с двумя строчками", modifier = Modifier.widthIn(max = 200.dp).padding(start = 25.dp, bottom = 10.dp), style = MaterialTheme.typography.bodyMedium, color = Color.Black, fontWeight = FontWeight.Medium)
                Button(modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 25.dp).width(160.dp).height(45.dp), onClick = onViewDetailsClick, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xff253334))) {
                    Text("подробнее", style = MaterialTheme.typography.titleSmall)
                }
            }
            Image(painter = painterResource(id = R.drawable.preview1), contentDescription = null, modifier = Modifier.heightIn(max = 140.dp).fillMaxSize().align(Alignment.CenterVertically))
        }
        Row(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp).clip(RoundedCornerShape(15.dp)).background(Color.White)) {
            Column {
                Text("Заголовок блока", modifier = Modifier.padding(start = 25.dp, top = 25.dp, bottom = 5.dp), fontSize = 25.sp, color = Color.Black, fontWeight = FontWeight.Normal)
                Text("Кратенькое описание блока с двумя строчками", modifier = Modifier.widthIn(max = 200.dp).padding(start = 25.dp, bottom = 10.dp), style = MaterialTheme.typography.bodyMedium, color = Color.Black, fontWeight = FontWeight.Medium)
                Button(modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 25.dp).width(160.dp).height(45.dp), onClick = onViewDetailsClick, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xff253334))) {
                    Text("подробнее", style = MaterialTheme.typography.titleSmall)
                }
            }
            Image(painter = painterResource(id = R.drawable.preview2), contentDescription = null, modifier = Modifier.heightIn(max = 140.dp).fillMaxSize().align(Alignment.CenterVertically))
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxSize().padding(start = 70.dp, end = 70.dp, bottom = 50.dp)) {
            Image(painter = painterResource(id = R.drawable.app_image), contentDescription = null, modifier = Modifier.size(40.dp))
            Image(painter = painterResource(id = R.drawable.navigation_button), contentDescription = null, modifier = Modifier.size(25.dp).offset(x = (-5).dp, y = 0.dp))
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = null, modifier = Modifier.size(25.dp))
        }
    }
}