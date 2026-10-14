package com.example.a4ariketadadoabota

import android.os.*
import androidx.activity.compose.*
import androidx.activity.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import com.example.a4ariketadadoabota.ui.theme._4AriketaDadoaBotaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _4AriketaDadoaBotaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DadoaBota(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DadoaBota(modifier: Modifier = Modifier) {
    var emaitza by remember { mutableIntStateOf(1) }
    val dadoa = when (emaitza) {
        1 -> R.drawable.dadoa_1
        2 -> R.drawable.dadoa_2
        3 -> R.drawable.dadoa_3
        4 -> R.drawable.dadoa_4
        5 -> R.drawable.dadoa_5
        else -> R.drawable.dadoa_6
    }
    Box (
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.fondoa),
            null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image (
                painter = painterResource(dadoa),
                "Dadoa: $emaitza",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button (
                onClick = { emaitza = (1..6).random()}
            ) {
                Text(text="Bota dadoa")
            }
        }
    }
}

@Preview
@Composable
fun DadoaBota_Preview() {
    DadoaBota()
}