package com.example.bankingapp

import androidx.annotation.DrawableRes

sealed class Screen(val title:String, val route:String) {
    sealed class BottomScreen(val bTitle: String, val bRoute : String, @DrawableRes val icon:Int):Screen(bTitle, bRoute)
    {
        object Deposit:BottomScreen(
            "Deposit",
            "Deposit",  // the navigation shall happen directly via broute(Deposit) described in the "foreach-> ..." code mentioned in the Account. Also the route for it is mentioned in Navigation.y
            R.drawable.baseline_subdirectory_arrow_left_24
        )
        object Pay:BottomScreen(
            "Pay",
            "Pay", // the navigation shall happen directly via the broute(pay) described in the "foreach-> ..." code  mentioned in the Account. Also the route for it is mentioned in Navigation.y
            R.drawable.baseline_qr_code_scanner_24
        )
    }
    sealed class DrawerScreen(val dTitle:String, val dRoute:String, @DrawableRes val icon:Int):Screen(dTitle, dRoute)
    {
        object Home:DrawerScreen(
            "Home",
            "Home",
            R.drawable.baseline_account_box_24
        )
        object Account:DrawerScreen(
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
    object HomeScreen: Screen("logIn_screen", "Login")
    object AccountHomeView: Screen("account_home_page", "AccountHomeView")
    object UserRegistration: Screen("User_Registration","UserRegistration")
    object AccountBalance: Screen("account_balance", "AccountBalance")
    object AccountTransaction: Screen("account_transaction", "AccountTransaction")
    object AccountLoan: Screen("account_loan", "AccountLoan")
    object QuickTransfer: Screen("quick_transfer", "QuickTransfer")
    object AddBeneficiary:Screen("add_beneficiary", "AddBeneficiary")

}

val ScreenInBottom: List<Screen.BottomScreen> =
    listOf(
        Screen.BottomScreen.Pay,
        Screen.BottomScreen.Deposit
    )

val ScreenInDrawer: List<Screen.DrawerScreen> =
    listOf(
        Screen.DrawerScreen.Home,
        Screen.DrawerScreen.Account,
        Screen.DrawerScreen.Settings)