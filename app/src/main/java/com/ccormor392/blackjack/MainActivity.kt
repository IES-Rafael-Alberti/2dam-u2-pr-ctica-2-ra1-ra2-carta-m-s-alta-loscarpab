package com.ccormor392.blackjack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ccormor392.blackjack.classes.Baraja
import com.ccormor392.blackjack.ui.theme.BlackjackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlackjackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MuestraCarta() {
    val context = LocalContext.current
    var nombreDrawable by rememberSaveable { mutableStateOf("reverso") }
    val barja = Baraja
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = context.resources.getIdentifier(
                    "carta$nombreDrawable",
                    "drawable",
                    context.packageName
                )
            ), contentDescription = "Carta vista", modifier = Modifier.size(400.dp)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp), horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                val cartaMostrada = barja.dameCarta()
                if (cartaMostrada == null){
                    nombreDrawable = "reverso"
                    Toast.makeText(context, "No quedan mas cartas", Toast.LENGTH_SHORT).show()
                } else  nombreDrawable = cartaMostrada.idDrawable.toString()
            }, modifier = Modifier.padding(end = 10.dp)) {
                Text(text = "Dame una carta $nombreDrawable ${barja.listaBaraja.size}")
            }
            Button(onClick = {
                barja.crearBaraja()
                nombreDrawable = "reverso"
                Toast.makeText(context, "Baraja reiniciada!", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Reiniciar")
            }
        }
    }
}

