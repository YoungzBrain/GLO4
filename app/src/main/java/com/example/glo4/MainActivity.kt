package com.example.glo4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glo4.Screens.CourseDetailScreen
import com.example.glo4.Screens.CoursesScreen
import com.example.glo4.Screens.HomeScreen
import com.example.glo4.Screens.ProfileScreen
import com.example.glo4.Screens.Login.LoginScreen
import com.example.glo4.ui.theme.GLO4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GLO4Theme {
                MainNavigation()
            }
        }
    }
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val userPreferences = remember { UserPreferences(context) }
    
    // Check login status from DataStore
    // We use "LOADING" as a sentinel value to wait for the first emission
    val username by userPreferences.getUsername.collectAsState(initial = "LOADING")

    if (username == "LOADING") {
        // Show a simple loader while checking DataStore
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    // Determine starting point: if username exists, go to home; otherwise, login.
    val startDestination = if (username != null) "home" else "login"

    NavHost(
        navController = navController, 
        startDestination = startDestination
    ) {
        composable("login") {
            LoginScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("courses") {
            CoursesScreen(navController)
        }
        composable("profile") {
            ProfileScreen(navController)
        }
        composable("course_detail") {
            CourseDetailScreen(navController)
        }
    }
}
