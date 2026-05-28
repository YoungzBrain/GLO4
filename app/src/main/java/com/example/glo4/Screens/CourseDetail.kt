package com.example.glo4.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.glo4.greenColor
import com.example.glo4.purpleColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.BookmarkBorder, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = purpleColor)
                ) {
                    Text("Continuer le cours", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding())
        ) {
            item {
                CourseDetailHeader()
            }
            item {
                CourseStatsSection()
            }
            item {
                AboutCourseSection()
            }
            item {
                Text(
                    text = "Contenu du cours",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
                )
            }
            itemsIndexed(listOf(
                "Introduction à Android" to "20 min",
                "Installation et configuration" to "45 min",
                "Layouts en Jetpack Compose" to "60 min",
                "Gestion des états" to "50 min",
                "Navigation" to "45 min"
            )) { index, (title, duration) ->
                LessonItem(index + 1, title, duration, index < 3)
            }
        }
    }
}

@Composable
fun CourseDetailHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(greenColor.copy(alpha = 0.3f), Color.White)
                )
            )
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Développement\nAndroid",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 32.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Apprenez à créer des applications Android modernes avec Kotlin et Jetpack Compose.",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            Icon(
                Icons.Default.Android,
                contentDescription = null,
                modifier = Modifier.size(120.dp),
                tint = greenColor
            )
        }
    }
}

@Composable
fun CourseStatsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatItem(Icons.Default.BarChart, "Niveau", "Intermédiaire")
        StatItem(Icons.Default.MenuBook, "Leçons", "24")
        StatItem(Icons.Default.Schedule, "Durée", "12h 30min")
    }
}

@Composable
fun StatItem(icon: ImageVector, label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(20.dp))
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
        Text(text = value, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun AboutCourseSection() {
    Column(modifier = Modifier.padding(24.dp)) {
        Text(text = "À propos du cours", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Ce cours vous guide pas à pas dans la création d'applications Android modernes en utilisant les meilleures pratiques et les outils recommandés par Google.",
            fontSize = 14.sp,
            color = Color.Gray,
            lineHeight = 20.sp
        )
    }
}

@Composable
fun LessonItem(number: Int, title: String, duration: String, isCompleted: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = number.toString(),
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.width(24.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Text(text = duration, fontSize = 12.sp, color = Color.Gray)
        }
        RadioButton(
            selected = isCompleted,
            onClick = null,
            colors = RadioButtonDefaults.colors(selectedColor = purpleColor)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CourseDetailPreview() {
    val navController = rememberNavController()
    CourseDetailScreen(navController = navController)
}
