package com.example.galeriapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.galeriapp.ui.theme.GaleriappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GaleriappTheme {
                GaleriaView()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    GaleriaView()
}

@Composable
fun GaleriaView(){
    val cuadros : List<Cuadro> =
    listOf(Cuadro(imagen = painterResource(R.drawable.noche),
        titulo = "La noche estrellada",
        autor = "Vincent Van Gogh"),
        Cuadro(imagen = painterResource(R.drawable.grito),
            titulo = "El grito",
            autor = "Edvard Munch"),
        Cuadro(imagen = painterResource(R.drawable.gioconda),
            titulo = "La gioconda",
            autor = "Leonardo Da Vinci"),
        Cuadro(imagen = painterResource(R.drawable.guernica),
            titulo = "Guernica",
            autor = "Pablo Picasso"),
        Cuadro(imagen = painterResource(R.drawable.meninas),
            titulo = "Las meninas",
            autor = "Diego Velazquez"))

    var nCuadro by remember  {mutableStateOf(0)}

    var cuadro = cuadros[nCuadro]

    Column(modifier= Modifier.padding(20.dp)
        .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Box(modifier = Modifier.padding(top = 30.dp)) {
            Image(
                contentDescription = "Imagen galeria",
                painter = cuadro.imagen,
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                modifier = Modifier.height(400.dp)
                    .fillMaxWidth()

            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = cuadro.titulo)
            Text(text = cuadro.autor)
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(){
            Button(onClick = {
                if (nCuadro>0){
                    nCuadro--
                } else {nCuadro = cuadros.size -1}
            }, modifier = Modifier.padding(10.dp)){
                Text(text = "Anterior")

            }
            Button(onClick = {
                if (nCuadro<cuadros.size-1){
                    nCuadro++
                } else {nCuadro = 0}
            }, modifier = Modifier.padding(10.dp)){
                Text(text = "Siguiente")

            }
        }

    }
}

class Cuadro(
    var imagen: Painter,
    var autor: String,
    var titulo: String
)

