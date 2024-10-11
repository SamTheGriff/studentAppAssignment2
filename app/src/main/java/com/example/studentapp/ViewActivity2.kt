package com.example.studentapp

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.studentapp.ui.theme.StudentAppTheme

class ViewActivity2 : AppCompatActivity() {

    private lateinit var cameraLauncher: ActivityResultLauncher<Void?>
    private var capturedImage by mutableStateOf<Bitmap?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Register the camera
        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap: Bitmap? ->
            capturedImage = bitmap // Save the captured image
        }

        setContent {
            StudentAppTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Button(onClick = {
                        //Launch the camera
                        cameraLauncher.launch(null)
                    }) {
                        Text("Capture Image")
                    }

                    // Show the image
                    capturedImage?.let { bitmap ->
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = "Captured Image"
                        )
                    }

                    Button(onClick = {
                        Intent(
                            baseContext,
                            MainActivity::class.java
                        ).also { startActivity(it) }
                    }) {
                        Text("Main Activity")
                    }
                }
            }
        }
    }
}
