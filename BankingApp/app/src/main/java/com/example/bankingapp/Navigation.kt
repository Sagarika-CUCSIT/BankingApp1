package com.example.bankingapp

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable


@Composable
fun Navigation(navController: NavHostController= rememberNavController())
{
    NavHost(navController= navController, startDestination=Screen.HomeScreen.route)
    {
                    composable(Screen.HomeScreen.route){
                        //Login(navController)
                        Login(navController)
                    }
                    composable(Screen.AccountHomeView.route){
                        AccountHomeView(navController)
                    }
                    composable(Screen.AccountBalance.route){
                        AccountBalance(navController)
                    }
                    composable(Screen.AccountTransaction.route)
                    {
                        AccountTransaction(navController)
                    }
                    composable(Screen.AccountLoan.route){
                        Loan(navController)
                    }
                    composable(Screen.DrawerScreen.Home.dRoute)
                    {
                        AccountHomeView(navController)
                    }
                    composable(Screen.DrawerScreen.Account.dRoute)
                    {
                        AccountBalance(navController)
                    }
                    composable(Screen.DrawerScreen.Settings.dRoute)
                    {
                        AccountHomeView(navController)
                    }
    }
}

//git remote add origin https://github.com/Sagarika-CUCSIT/BankingApp.git
