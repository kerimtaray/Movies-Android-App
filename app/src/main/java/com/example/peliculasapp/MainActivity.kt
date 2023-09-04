package com.example.peliculasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.peliculasapp.screens.home.HomeScreen
import com.example.peliculasapp.ui.theme.PeliculasAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeliculasAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(navController, startDestination = "movieList") {
                        composable("movieList") {
                            HomeScreen(
                                onMovieClick = { movieId ->
                                    navController.navigate("movieDetails/$movieId")
                                }
                            )
                        }
                        composable("movieDetails/{movieId}") { backStackEntry ->
                            val movieId = backStackEntry.arguments?.getString("movieId")
                            DetailsScreen(movieId)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DetailsScreen(movieId: String?) {
    Text(text = "Detalles de la película: $movieId")
}
