package com.example.glo4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glo4.Screens.CourseDetailScreen
import com.example.glo4.Screens.CoursesScreen
import com.example.glo4.Screens.HomeScreen
import com.example.glo4.Screens.ProfileScreen
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
    NavHost(navController = navController, startDestination = "home") {
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainNavigationPreview() {
    GLO4Theme {
        MainNavigation()
    }
}
