package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.UserDao

@Composable
fun ProfileScreen(navController: NavController, userDao: UserDao) {
    val userLiveData = userDao.getUserLiveData() // Assuming user ID 1 for simplicity

    var firstName by remember { mutableStateOf(userLiveData.value?.firstName ?: "") }
    var lastName by remember { mutableStateOf(userLiveData.value?.lastName ?: "") }
    var email by remember { mutableStateOf(userLiveData.value?.email ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(150.dp)
        )
        InfoInput2("Name", firstName) { firstName = it }
        Spacer(modifier = Modifier.height(8.dp))
        InfoInput2("Last Name", lastName) { lastName = it }
        Spacer(modifier = Modifier.height(8.dp))
        InfoInput2("Email", email) { email = it }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("menu") }
        ) {
            Text("Ir al Menú")
        }
        Button(
            onClick = { }
        ) {
            Text("Log Out")
        }
    }
}

@Composable
fun InfoInput2(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}
