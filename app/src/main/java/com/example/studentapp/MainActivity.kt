package com.example.studentapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentapp.ui.theme.StudentAppTheme
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudentAppTheme {
            CardPreview()

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(-100.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(onClick = {
                            Intent(
                                baseContext,
                                SecondActivity::class.java
                            ).also { startActivity(it) }
                        }) {
                            Text("Start Activity Explicitly")

                        }

                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(onClick = {
                            Intent(
                                baseContext,
                                SecondActivity::class.java
                            ).also { startActivity(it) }
                        }) {
                            Text("Start Activity Implicitly")
                        }
                    }

            }
            }
        }

    }



@Composable
fun CardPreview() {
    StudentAppTheme {
        GreetingText(message = "\nHello, my name is Sam Griffin\nMy student ID is 1389930")
    }
}

@Composable
fun GreetingText(message: String, modifier: Modifier = Modifier) {
    Text( text = message,
        fontSize = 50.sp,
        lineHeight = 55.sp,
        textAlign = TextAlign.Center
        )

}










