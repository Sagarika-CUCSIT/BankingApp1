package com.example.bankingapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Loan(navController: NavController) {
    Scaffold(topBar = {
        AppBarView(title = "Loan") //AppBarView() is defined in AppBarSyntax
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
            val boxSize = 100.dp
            val buttonModifier = Modifier
                .size(boxSize)
                .border(1.dp, Color.Black)
                .padding(8.dp)
                .clickable { /* Handle click here */ }

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
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = "Banking App",
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp) // space between rows
                    ) {
                        // First Row
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = buttonModifier.clickable {
                                    // Handle Home Loan click
                                    navController.navigate("home_loan")
                                }
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Home Loan")
                                }
                            }

                            Box(
                                modifier = buttonModifier.clickable {
                                    // Handle Car Loan click
                                    navController.navigate("car_loan")
                                }
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Car Loan")
                                }
                            }

                            Box(
                                modifier = buttonModifier.clickable {
                                    // Handle Personal Loan click
                                    navController.navigate("personal_loan")
                                }
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Personal Loan")
                                }
                            }
                        }

                        // Second Row
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = buttonModifier.clickable {
                                    // Handle Gold Loan click
                                    navController.navigate("gold_loan")
                                }
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Gold Loan")
                                }
                            }

                            Box(
                                modifier = buttonModifier.clickable {
                                    // Handle Education Loan click
                                    navController.navigate("education_loan")
                                }
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Education Loan")
                                }
                            }

                            Box(
                                modifier = buttonModifier.clickable {
                                    // Handle Loan Against Mutual Funds click
                                    navController.navigate("loan_against_mutual_funds")
                                }
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Loan Against Mutual Funds")
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
fun LoanPreview(){
    val navController = rememberNavController()
    Loan(navController = navController)
}