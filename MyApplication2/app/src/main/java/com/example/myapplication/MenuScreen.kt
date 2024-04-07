package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Profile Image",
                    modifier = Modifier.size(150.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(75.dp)
                        .clickable {
                            navController.navigate("profile")
                        }
                )
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color(0xFF495E57))
            ) {
                Text("Little Lemon")

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Chicago")
                    Text("Description goes here")
                    Image(
                        painter = painterResource(id = R.drawable.heroimage),
                        contentDescription = "Hero Image",
                        modifier = Modifier.size(200.dp)
                    )

                    TextField(
                        value = "", // Add your search text state here
                        onValueChange = {}, // Add your search text change callback here
                        placeholder = { Text("Search") },
                        modifier = Modifier.weight(1f)
                    )
                }

            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = { /* Handle click */ }) {
                        Text("Starters")
                    }
                    Button(onClick = { /* Handle click */ }) {
                        Text("Mains")
                    }
                    Button(onClick = { /* Handle click */ }) {
                        Text("Desserts")
                    }
                    Button(onClick = { /* Handle click */ }) {
                        Text("Drinks")
                    }
                    Button(onClick = { /* Handle click */ }) {
                        Text("Others")
                    }
                }
            }
        }

        items(4) { index ->
            ProductItem(
                title = when (index) {
                    0 -> "bruschetta"
                    1 -> "greeksalad"
                    2 -> "pasta"
                    else -> "lemondessert"
                },
                description = when (index) {
                    0 -> "$12.00"
                    1 -> "$8.00"
                    2 -> "$13.00"
                    else -> "$5.00"
                },
                price = when (index) {
                    0 -> "$12.00"
                    1 -> "$8.00"
                    2 -> "$13.00"
                    else -> "$5.00"
                },
                imageRes = when (index) {
                    0 -> R.drawable.bruschetta
                    1 -> R.drawable.greeksalad
                    2 -> R.drawable.pasta
                    else -> R.drawable.lemondessert
                }
            )
        }
    }
}

@Composable
fun ProductItem(title: String, description: String, price: String, imageRes: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title)
            Spacer(modifier = Modifier.width(16.dp))
            Text(description)
            Spacer(modifier = Modifier.width(16.dp))
            Text(price)
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Product Image",
                modifier = Modifier.size(200.dp)
            )
        }
    }
}
