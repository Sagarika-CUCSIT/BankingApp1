package com.example.bankingapp

import androidx.annotation.DrawableRes

sealed class Screen(val title:String, val route:String) {
    sealed class DrawerScreen(val dTitle:String, val dRoute:String, @DrawableRes val icon:Int):Screen(dTitle, dRoute)
    {
        object Home:DrawerScreen(
            "Home",
            "Home",
            R.drawable.baseline_account_box_24
        )
        object Deposits:DrawerScreen(
            "Account",
            "Account",
            R.drawable.baseline_money_24
        )
        object Settings:DrawerScreen(
            "Settings",
            "Settings",
            R.drawable.baseline_settings_24
        )
    }
    object HomeScreen: Screen("logIn_screen", "Home")
    object Account: Screen("account_home_page", "Account")
    object AccountBalance: Screen("account_balance", "AccountBalance")
    object AccountTransaction: Screen("account_transaction", "AccountTransaction")
    object AccountLoan: Screen("account_loan", "AccountLoan")

}

val ScreenInDrawer: List<Screen.DrawerScreen> =
    listOf(
        Screen.DrawerScreen.Home,
        Screen.DrawerScreen.Deposits,
        Screen.DrawerScreen.Settings)