package com.example.juandavidchurata

import android.os.Bundle

import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.juandavidchurata.ui.theme.JuanDavidChurataTheme

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.ColorFilter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JuanDavidChurataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PersonalCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PersonalCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize() // Asegura que la columna ocupe toda la pantalla
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Centrar horizontalmente
        verticalArrangement = Arrangement.Center // Centrar verticalmente
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Usa tu imagen aquí
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(100.dp) // Tamaño de la imagen
                .aspectRatio(1f)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre completo centrado
        Text(
            text = "Juan David Camilo Churata Mamani",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally) // Se asegura de que el texto esté centrado
        )

        // Título también centrado
        Text(
            text = "Especialista",
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally) // Centra el título horizontalmente
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Número de teléfono
        InfoItem(icon = R.drawable.ic_phone, text = "+56 9 4350 2121")

        // Handle de redes sociales
        InfoItem(icon = R.drawable.ic_social, text = "@Juajo12")

        // Correo electrónico
        InfoItem(icon = R.drawable.ic_email, text = "ajenjo2550@gmail.com")
    }
}


@Composable
fun InfoItem(icon: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JuanDavidChurataTheme {
        PersonalCard()
    }
}
