package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ProfileScreen
import com.example.myapplication.AppDatabase
import com.example.myapplication.MenuScreen
import com.example.myapplication.UserDao
import com.example.myapplication.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userDao = AppDatabase.getDatabase(applicationContext).userDao()
        setContent {
            val navController = rememberNavController()
            MyApp(navController = navController, userDao = userDao)
        }
    }
}

@Composable
fun MyApp(navController: NavHostController, userDao: UserDao) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController, userDao) }
        composable("menu") { MenuScreen(navController) }
        composable("profile") { ProfileScreen(navController, userDao) }
        // Define other destinations here
    }
}
