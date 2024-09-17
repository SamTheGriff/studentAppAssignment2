package com.example.studentapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.studentapp.databinding.ActivitySecondBinding
import com.example.studentapp.ui.theme.StudentAppTheme

class SecondActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            StudentAppTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Text( text = "Five mobile software engineering challenges:",
                        fontSize = 35.sp,
                        lineHeight = 50.sp,
                        textAlign = TextAlign.Center

                    )

                    Text( text = "1. Smaller screen size means intuitive and good apps are hard to develop.",
                        fontSize = 20.sp,
                        lineHeight = 40.sp,
                        textAlign = TextAlign.Center
                    )

                    Text( text = "2. Limited performance of mobile devices.",
                        fontSize = 20.sp,
                        lineHeight = 40.sp,
                        textAlign = TextAlign.Center
                    )

                    Text( text = "3. Compatability with multiple different devices.",
                        fontSize = 20.sp,
                        lineHeight = 40.sp,
                        textAlign = TextAlign.Center
                    )

                    Text( text = "4. Bad efficiency/performance can quickly drain mobile device' batteries quickly.",
                        fontSize = 20.sp,
                        lineHeight = 40.sp,
                        textAlign = TextAlign.Center
                    )

                    Text( text = "5. Offline support is essential in this age, and mobile apps need to be at least partially usable offline.",
                        fontSize = 20.sp,
                        lineHeight = 40.sp,
                        textAlign = TextAlign.Center
                    )

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


    }}