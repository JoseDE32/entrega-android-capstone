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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun WelcomeScreen(navController: NavController, userDao: UserDao) {
    var firstName by remember { mutableStateOf(TextFieldValue()) }
    var lastName by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }

    val coroutineScope = rememberCoroutineScope()

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
        Spacer(modifier = Modifier.height(16.dp))
        BarWithText("Green Bar Text")
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Personal Information"
        )
        Spacer(modifier = Modifier.height(8.dp))
        InfoInput("Name", firstName) { firstName = it }
        Spacer(modifier = Modifier.height(8.dp))
        InfoInput("Last Name", lastName) { lastName = it }
        Spacer(modifier = Modifier.height(8.dp))
        InfoInput("Email", email) { email = it }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val user = User(
                    firstName = firstName.text,
                    lastName = lastName.text,
                    email = email.text
                )
                // Guardar el usuario en la base de datos antes de navegar al menú
                coroutineScope.launch {
                    userDao.insertUser(user)
                    navController.navigate("menu")
                }
            }
        ) {
            Text("Ir al Menú")
        }
    }
}

@Composable
fun BarWithText(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color(0xFF495E57))
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center),
            color = Color.White
        )
    }
}

@Composable
fun InfoInput(label: String, textValue: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
    OutlinedTextField(
        value = textValue,
        onValueChange = { onValueChange(it) },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}
