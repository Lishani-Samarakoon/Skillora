package com.example.silloramobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.silloramobileapp.navigation.AppNavGraph
import com.example.silloramobileapp.ui.theme.SilloraMobileAppTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)

        setContent {
            SilloraMobileAppTheme {
                AppNavGraph()
            }
        }
    }
}