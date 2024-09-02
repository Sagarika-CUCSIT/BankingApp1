package com.example.bankingapp

import UserRegistration
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


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
                    composable(Screen.UserRegistration.route){
                        UserRegistration(navController)
                    }
                    composable(Screen.BottomScreen.Deposit.bRoute){
                        Deposit(navController)
                    }
                    composable(Screen.BottomScreen.Pay.bRoute){
                        Pay(navController)
                    }
    }
}

//git remote add origin https://github.com/Sagarika-CUCSIT/BankingApp.git
