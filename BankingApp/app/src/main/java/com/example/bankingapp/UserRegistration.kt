import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bankingapp.AppBarView

@Composable
fun UserRegistration(navController: NavController) {
    var accountNumber by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var cifNumber by remember { mutableStateOf("") }
    var branchCode by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }

    Scaffold(topBar = {
        AppBarView(title = "User Registration")
        { navController.navigateUp() }
    }) {
        Column(
            modifier = Modifier.padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(
                        BorderStroke(
                            1.dp,
                            Color.Gray
                        )
                    ) // Optional: Border for better visibility
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        Text(
                            text = "Register",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }

                    item {
                        TextField(
                            value = accountNumber,
                            onValueChange = { accountNumber = it },
                            label = { Text("Account Number *") },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                        )
                    }

                    item {
                        TextField(
                            value = cifNumber,
                            onValueChange = { cifNumber = it },
                            label = { Text("CIF Number *") },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                        )
                    }

                    item {
                        TextField(
                            value = branchCode,
                            onValueChange = { branchCode = it },
                            label = { Text("Branch Code *") },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                        )
                    }

                    item {
                        TextField(
                            value = fullName,
                            onValueChange = { fullName = it },
                            label = { Text("Full Name *") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    item {
                        TextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email *") },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
                        )
                    }

                    item {
                        TextField(
                            value = phoneNumber,
                            onValueChange = { phoneNumber = it },
                            label = { Text("Phone Number *") },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone)
                        )
                    }

                    item {
                        TextField(
                            value = country,
                            onValueChange = { country = it },
                            label = { Text("Country *") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    item {
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Password *") },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    item {
                        TextField(
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            label = { Text("Confirm Password *") },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    item {
                        Button(
                            onClick = {
                                // Handle registration logic here
                                //navController.navigate(Screen.AccountHomeView.route)
                            },
                            modifier = Modifier.align(Alignment.End).padding(top = 16.dp)
                        ) {
                            Text("Register")
                        }
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun RegistrationPreview() {
    val navController = rememberNavController()
    UserRegistration(navController = navController)
}
