package com.example.peliculasapp.screens.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailsScreen(movieId: String?) {
    Text(text = "Detalles de la película: $movieId")
}
