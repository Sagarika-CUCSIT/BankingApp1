package com.example.bankingapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
/*
@Composable
fun AccountBalanceView(navController: NavController) {
    Scaffold(topBar = {
        AppBarView(title = "Account Balance")
            { navController.navigateUp() }
    }) {

    }
    */
    @Composable
    fun AccountBalance(navController: NavController) {

    // Sample account number and balance
    val accountNumber = "6268374749438"
    val balance = "Rs. 78000.00"

    fun formatAccountNumber(accountNumber: String): String {
        val visibleDigits = 3
        val maskLength = accountNumber.length - visibleDigits
        val maskedPart = "x".repeat(maskLength)
        val visiblePart = accountNumber.takeLast(visibleDigits)
        return "$maskedPart$visiblePart"
    }
    Scaffold(topBar = {
        AppBarView(title = "Account Balance")
        { navController.navigateUp() }
    })
    {
        Column(
            modifier = Modifier.padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            // Card to hold the account balance details
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        BorderStroke(
                            1.dp,
                            Color.Gray
                        )
                    ) // Optional: Border for better visibility
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .heightIn(min = 100.dp), // Adjust height as needed
                    horizontalArrangement = Arrangement.SpaceBetween // Space between the blocks
                ) {
                    // Account number
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 16.dp) // Add space between columns
                    ) {
                        Text(
                            text = "Account No.",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = formatAccountNumber(accountNumber),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }

                    // Balance
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Balance",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = balance,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        // Placeholder for the Transaction History Button
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                            //.padding(top = 8.dp), // Adjust padding as needed
                            //contentAlignment = Alignment.End // Align button to the end of the Box
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = { /* Handle transaction history button click */ },
                                    shape = RectangleShape,
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Black,  // Background color of the button
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text("Transaction History")
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
@Preview
@Composable
fun AccountBalancePreview() {
                val navController = rememberNavController()
                AccountBalance(navController = navController)
            }