package com.example.bankingapp

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun Pay(navController: NavController) {
    Scaffold(topBar = {
        AppBarView(title = "Account Balance")
        { navController.navigateUp() }
    }){
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val boxSize = 120.dp
            val buttonModifier = Modifier
                .size(boxSize)
                .border(1.dp, Color.Black)
                .padding(8.dp)
                .clickable { /* Handle click here */ }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Account Balance Button
                    Box(
                        modifier = buttonModifier.clickable {
                            navController.navigate(Screen.AccountBalance.route)
                        },

                    ) {
                        Text(
                            text = "Quick Transfer",
                            //maxLines = 1,
                            //overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    }

                    // Loan Button
                    Box(
                        modifier = buttonModifier.clickable {
                            navController.navigate(Screen.AccountLoan.route)
                        }
                    ) {
                        Text(
                            text = "Add Beneficiary",
                            //maxLines = 2,
                            //overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center

                        )
                    }
                }


            }
        }
    }
}
@Preview
@Composable
fun PayPreview(){
    val navController = rememberNavController()
    Pay(navController = navController)
}