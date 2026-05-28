package com.example.glo4.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = {
                if (currentRoute != "home") {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            },
            icon = { Icon(Icons.Default.Home, contentDescription = "Accueil") },
            label = { Text("Accueil") }
        )

        NavigationBarItem(
            selected = currentRoute == "courses",
            onClick = {
                if (currentRoute != "courses") {
                    navController.navigate("courses")
                }
            },
            icon = { Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = "Cours") },
            label = { Text("Cours") }
        )

        NavigationBarItem(
            selected = currentRoute == "favorites",
            onClick = {
                // navController.navigate("favorites")
            },
            icon = { Icon(Icons.Default.FavoriteBorder, contentDescription = "Favoris") },
            label = { Text("Favoris") }
        )

        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = {
                if (currentRoute != "profile") {
                    navController.navigate("profile")
                }
            },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
            label = { Text("Profil") }
        )
    }
}
