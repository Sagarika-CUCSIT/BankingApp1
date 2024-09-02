package com.example.bankingapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Deposit(navController: NavController) {
    androidx.compose.material3.Scaffold(topBar = {
        AppBarView(title = "Account Balance")
        { navController.navigateUp() }
    }){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .border(BorderStroke(1.dp, Color.Gray)) // Optional: Border for better visibility
        ) {

            // Add a Spacer to create some space at the top
            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.padding(16.dp)) {
               // In Jetpack Compose, Column is a layout composable that arranges its children vertically, one after another. It is similar to a vertical LinearLayout in the traditional Android View system.
                Text(
                    text = "Deposit",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                var Amount = remember { mutableStateOf("") }
                var AccountNumber = remember { mutableStateOf("") }
                TextField(
                    value = Amount.value,
                    onValueChange = { Amount.value = it },
                    label = { Text("Amount") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )


                TextField(
                    value = AccountNumber.value,
                    onValueChange = { AccountNumber.value = it },
                    label = { Text("Account Number") },
                    // visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Deposit")
                }

            }
        }
    }
}
@Preview
@Composable
fun DepositPreview() {
    val navController = rememberNavController()
    Deposit(navController = navController)
}
