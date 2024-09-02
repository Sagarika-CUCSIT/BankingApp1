package com.example.bankingapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.*
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

/*
@Composable
fun HomeView() {
    val context = LocalContext.current
    Scaffold(topBar = {},
        )
}*/
@Composable
fun Login(navController: NavController) {//login: LogIn
    Scaffold { innerPadding ->
      //  innerPadding is a parameter that represents the padding to be applied to the content of a Scaffold in Jetpack Compose. The Scaffold is a layout that provides slots for the most common components of an app screen, such as the top bar, bottom bar, floating action button, and content area.
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .border(BorderStroke(1.dp, Color.Gray)) // Optional: Border for better visibility
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                //  In Jetpack Compose, Column is a layout composable that arranges its children vertically, one after another. It is similar to a vertical LinearLayout in the traditional Android View system.
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                var username = remember { mutableStateOf("") }
                var password = remember { mutableStateOf("") }
                TextField(
                    value = username.value,
                    onValueChange = { username.value = it },
                    label = { Text("Username") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )


                TextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Button(
                    onClick = { navController.navigate(Screen.AccountHomeView.route) },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Login")
                }

                // Spacer to add some space between the Button and the ClickableText
                Spacer(modifier = Modifier.height(16.dp))

                // ClickableText for the hyperlink
                ClickableText(
                    text = AnnotatedString("New user? Click here to register"),
                    /*An AnnotatedString in Jetpack Compose is a special kind of string that allows you to attach various styles and annotations to specific parts of the text.
                This is useful when you want to apply different text styles, colors, or behaviors (like click actions) to different parts of the same text.
                Key Features of AnnotatedString:
                       --> Text Styling: You can apply different styles, such as bold, italic, underline, color, etc., to different sections of the text.

                       --> Annotations: You can associate metadata or actions with specific parts of the text. For example, you might attach a URL to a portion of the text, making it behave like a hyperlink.

                       --> Span-like Behavior: AnnotatedString is similar to SpannableString in Android’s XML-based UI framework, where you can apply spans to parts of a string for styling or interaction purposes.*/
                    onClick = { navController.navigate(Screen.UserRegistration.route) }, // Navigate to registration screen
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

            }
        }
    }
}
@Preview
@Composable
fun LoginPreview(){

    // Create a mock NavController
    val navController = rememberNavController()

    Login(navController = navController)
}