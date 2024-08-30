package com.example.bankingapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountHomeView(navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val viewModel: MainViewModel = viewModel()
    val currentScreen = remember { viewModel.currentScreen.value }
    val title = remember { mutableStateOf(currentScreen.title) }
    val bottomBar: @Composable () -> Unit = {
        //if (currentScreen is Screen.DrawerScreen || currentScreen is Screen.BottomScreen) {
        NavigationBar(Modifier.wrapContentSize()) {
            ScreenInBottom.forEach { item ->
                NavigationBarItem(
                    selected = currentScreen == item,
                    onClick = { navController.navigate(item.bRoute) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.bTitle
                        )
                    },
                    label = { Text(text = item.bTitle) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Blue, // Customize selected icon color
                        unselectedIconColor = Color.Gray, // Customize unselected icon color
                        selectedTextColor = Color.Blue, // Customize selected text color
                        unselectedTextColor = Color.Gray // Customize unselected text color
                    )
                )
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            //Box(
              //  modifier = Modifier
                //    .background(Color.White)// Set background color of the drawer here
                //    .size(300.dp)
            //)
            LazyColumn(
                Modifier
                    .padding(WindowInsets.statusBars.asPaddingValues())
                    .background(Color.White)
                    .size(300.dp)) {
                items(ScreenInDrawer) { item ->
                    DrawerItem(selected = navController.currentBackStackEntryAsState().value?.destination?.route == item.dRoute, item = item) {
                        scope.launch {
                            drawerState.close()
                        }
                        if (item.dRoute == "add_account") {
                            // Open add account dialog box
                        } else {
                            navController.navigate(item.dRoute)
                            title.value = item.dTitle
                        }
                    }
                }
            }
        },
        content = {
            Scaffold(
                bottomBar = bottomBar,
                topBar = {
                    TopAppBar(
                        title = { Text("Banking App") },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")
                            }
                        }//here the functionality is such that upon clicking the Account icon, the drawer should open and clicking anywhere outside the drawer should close it
                    )
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
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
                            .border(BorderStroke(1.dp, Color.Gray))
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Top
                        ) {
                            /*Text(
                                text = "Banking App",
                                style = MaterialTheme.typography.headlineLarge,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )*/

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                    // Account Balance Button
                                    Box(
                                        modifier = buttonModifier.clickable {
                                            navController.navigate(Screen.AccountBalance.route)
                                        }
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(text = "Account Balance")
                                        }
                                    }

                                    // Loan Button
                                    Box(
                                        modifier = buttonModifier.clickable {
                                            navController.navigate("loan")
                                        }
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(text = "Loan")
                                        }
                                    }
                                }

                                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                    // Investment Button
                                    Box(
                                        modifier = buttonModifier.clickable {
                                            navController.navigate("investment")
                                        }
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(text = "Investment")
                                        }
                                    }

                                    // Misc Button
                                    Box(
                                        modifier = buttonModifier.clickable {
                                            navController.navigate("misc")
                                        }
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(text = "Misc")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked: () -> Unit
) {
    val background = if (selected) Color.DarkGray else Color.White

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable {
                onDrawerItemClicked()
            }
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTitle,
            Modifier.padding(end = 8.dp, top = 4.dp)
        )
        Text(
            text = item.dTitle,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun AccountPreview() {
    val navController = rememberNavController()
    AccountHomeView(navController = navController)
}



/*
@Composable
fun Account(navController: NavController) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    //inorder to be able to import scaffoldState and rememberScaffoldState(),
    // the same dependencies for it must be declared in build.gradle.kts(module:app) in the dependencies section.
    val scope: CoroutineScope = rememberCoroutineScope() //CoroutineScope is required for opening and closing a drawer
    //opening and closing a drawer is an asynchronous method and thus coroutines are required.
    //ie the concepts of suspend methods (of thread class puts the thread from running to waiting state) are used.
    val viewModel: MainViewModel = viewModel() //related to the MainViewModel.kt
    //The lines below allow us to find out on which "View" we currently are in
    val controller: NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentScreen = remember{
        viewModel.currentScreen.value
    }
    val title= remember {
        //change that to current screen title ie the structure of the page remains the same only the title changes uppon the respective button being clicked from the drawer
        //viewModel.currentScreen.value
        mutableStateOf(currentScreen.title)
        //title is held by sealed class Screen in Screen.kt, the same is now passed to currentScreen in MainViewModel which is called here.
        //mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(onClick = {
                        /*open the drawer*/
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    })
                    {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn(Modifier.padding(16.dp)) {
                items(ScreenInDrawer) {
                    //selected parameter in DrawerItem is defined as boolean above, thus it sets the
                    //cuurent screen(ie CurrentRoute) that is being displayed.
                        item ->
                    DrawerItem(selected = currentRoute == item.dRoute, item = item) {
                        scope.launch { //it is of coroutine scope
                            scaffoldState.drawerState.close()
                        } //this closes the drawer when will click any other area next to the drawer
                    }
                    if (item.dRoute == "add_account") {
                        //open add account dialog box
                    } else {
                        controller.navigate(item.dRoute)
                        title.value =
                            item.dTitle //basically, upon clicking any button only the title value should be changed, rest structure of body remains the same
                        //title is a state holder declared above as "val title=...."
                    }
                }


            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            // Define a uniform size for buttons and boxes
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
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp) // space between rows
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            // Account Balance Button
                            Box(
                                modifier = buttonModifier.clickable {
                                    // Handle Account Balance click
                                    navController.navigate(Screen.AccountBalance.route)
                                }
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Account Balance")
                                }
                            }

                            // Loan Button
                            Box(
                                modifier = buttonModifier.clickable {
                                    // Handle Loan click
                                    navController.navigate("loan")
                                }
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Loan")
                                }
                            }
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            // Investment Button
                            Box(
                                modifier = buttonModifier.clickable {
                                    // Handle Investment click
                                    navController.navigate("investment")
                                }
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Investment")
                                }
                            }

                            // Misc Button
                            Box(
                                modifier = buttonModifier.clickable {
                                    // Handle Misc click
                                    navController.navigate("misc")
                                }
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Misc")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}*/
/*package com.example.bankingapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun Account(navController: NavController) {
    // Define a uniform size for buttons and boxes
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
            .border(BorderStroke(1.dp, Color.Gray)) // Optional: Border for better visibility
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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp) // space between rows
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    // Account Balance Button
                    Box(
                        modifier = buttonModifier.clickable {
                            // Handle Account Balance click
                            navController.navigate(Screen.AccountBalance.route)
                        }
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Account Balance")
                        }
                    }

                    // Loan Button
                    Box(
                        modifier = buttonModifier.clickable {
                            // Handle Loan click
                            navController.navigate("loan")
                        }
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Loan")
                        }
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    // Investment Button
                    Box(
                        modifier = buttonModifier.clickable {
                            // Handle Investment click
                            navController.navigate("investment")
                        }
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Investment")
                        }
                    }

                    // Misc Button
                    Box(
                        modifier = buttonModifier.clickable {
                            // Handle Misc click
                            navController.navigate("misc")
                        }
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Misc")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AccountPreview(){
    val navController = rememberNavController()
    Account(navController = navController )
}*/