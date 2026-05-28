package com.example.glo4

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

val greenColor = Color(0xFF4CAF50)
val purpleColor = Color(0xFF4A10B5)
val yellowColor = Color(0xFFFFA000)
val lightPurple = Color(0xFFF3F0FF)

data class Course(
    val title: String,
    val description: String,
    val progress: Int,
    val icon: ImageVector,
    val color: Color,
    val level: String = "Intermédiaire",
    val lessons: Int = 24
)

val courses = listOf(
    Course(
        title = "Développement Android",
        description = "Apprenez à créer des applications Android modernes avec Kotlin et Jetpack Compose.",
        progress = 40,
        icon = Icons.Default.PhoneAndroid,
        color = purpleColor,
        level = "Intermédiaire",
        lessons = 24
    ),
    Course(
        title = "Kotlin Fondamentaux",
        description = "Maîtrisez les bases du langage Kotlin.",
        progress = 0,
        icon = Icons.Default.Code,
        color = Color(0xFF673AB7),
        level = "Débutant",
        lessons = 18
    ),
    Course(
        title = "Jetpack Compose",
        description = "Construisez des interfaces utilisateur modernes avec Compose.",
        progress = 0,
        icon = Icons.Default.PhoneAndroid,
        color = Color(0xFF2196F3),
        level = "Intermédiaire",
        lessons = 20
    ),
    Course(
        title = "Bases de données",
        description = "Découvrez Room et gérez vos données locales.",
        progress = 75,
        icon = Icons.Default.Storage,
        color = yellowColor,
        level = "Intermédiaire",
        lessons = 16
    )
)

data class Category(
    val name: String,
    val icon: ImageVector,
    val color: Color
)

val categories = listOf(
    Category("Tous", Icons.Default.Code, purpleColor),
    Category("Android", Icons.Default.PhoneAndroid, greenColor),
    Category("Kotlin", Icons.Default.Code, purpleColor),
    Category("UI/UX", Icons.Default.PhoneAndroid, Color.Blue),
    Category("Base de données", Icons.Default.Storage, yellowColor)
)
