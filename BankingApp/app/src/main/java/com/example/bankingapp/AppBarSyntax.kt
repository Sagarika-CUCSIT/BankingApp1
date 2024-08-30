package com.example.bankingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
//import androidx.compose.material.Text
//import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.reflect.Modifier



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView(
    title:String,
    onBackNavClicked:() -> Unit ={}){
    val navigationIcon: (@Composable ()-> Unit)?=
        {
        IconButton(onClick={onBackNavClicked()})
        {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                tint= Color.Black,
                contentDescription = null)

        }
    }
    if (navigationIcon != null) {
        TopAppBar(
            title = {
                Text(text=title,
                    color= colorResource(id = R.color.black))
                //modifier = Modifier
                //  .padding(start=4.dp)
                //.heightIn(max=24.dp))
            },
            //elevation=3.dp,
            //containerColor= colorResource(id = R.color.purple_200),
            navigationIcon=navigationIcon
        )
    }
}

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

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
    Scaffold(topBar = { TopAppBar(
        title = { Text("Home") },
        navigationIcon = {
            IconButton(onClick = {
                /*open the drawer*/
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            })
            {
                Icon(imageVector= Icons.Default.AccountCircle, contentDescription ="Menu")
            }
        }
    )
    }, scaffoldState=scaffoldState,
        drawerContent = {
            LazyColumn(androidx.compose.ui.Modifier.padding(16.dp)){
                items(ScreenInDrawer){
                    //selected parameter in DrawerItem is defined as boolean above, thus it sets the
                    //cuurent screen(ie CurrentRoute) that is being displayed.
                        item -> DrawerItem(selected = currentRoute == item.dRoute, item = item) {
                    scope.launch{ //it is of coroutine scope
                        scaffoldState.drawerState.close()} //this closes the drawer when will click any other area next to the drawer
                }
                    if(item.dRoute == "add_account")
                    {
                        //open add account dialog box
                    }else{
                        controller.navigate(item.dRoute)
                        title.value = item.dTitle //basically, upon clicking any button only the title value should be changed, rest structure of body remains the same
                        //title is a state holder declared above as "val title=...."
                    }
                }




            }
        }
    )
    {
        Navigation(navController = controller, viewModel = viewModel, pd = it)
    }

    /*
    topBar= {TopAppBar(title={ Text( "Home")},
        navigationIcon={ IconButton(onClick={
            //open the drawer
          })
    ){
        Text("Text", modifier= Modifier.padding(it))
    }*/

}/*
@Composable
fun DrawerItem(
    selected:Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked : () -> Unit)
{
    val background = if (selected) Color.DarkGray else Color.White
    //here selected is declared to be boolean in the function parameter above,
    //thus, it is ensured that if the area is selected it shall be DarkGray in color else it should be white(Thus, boolean)

    Row(
        androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background) //background passed as paramter is the background declared above as a variable
            .clickable {
                onDrawerItemClicked()
            }){
        androidx.compose.material.Icon(painter = painterResource(id = item.icon),
            contentDescription = item.dTitle,
            androidx.compose.ui.Modifier.padding(end = 8.dp, top = 4.dp))
        Text(text=item.dTitle,style= MaterialTheme.typography.titleMedium)
    }

}
@Composable
fun Navigation(navController: NavController, viewModel: MainViewModel, pd: PaddingValues){
    NavHost(navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.Home.dRoute,
        modifier = androidx.compose.ui.Modifier.padding(pd) ) {
        composable(Screen.DrawerScreen.Deposits.dRoute){
            Account(navController)
        }
        composable(Screen.DrawerScreen.Settings.dRoute){

        }
        composable(Screen.Account.route){
            Account(navController)
        }
    }
}*/