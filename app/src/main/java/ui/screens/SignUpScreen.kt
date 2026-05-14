package com.example.silloramobileapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.silloramobileapp.R
import com.example.silloramobileapp.data.FirebaseManager
import com.example.silloramobileapp.ui.theme.BrandBlue
import com.example.silloramobileapp.ui.theme.BrandDark
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    onBackClick: () -> Unit,
    onSignInClick: () -> Unit,
    onCreateAccountClick: () -> Unit
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var district by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf("offer") }
    var errorMessage by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.app_background),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = BrandDark
                        )
                    }

                    Spacer(modifier = Modifier.width(4.dp))

                    Image(
                        painter = painterResource(id = R.drawable.logo_skillora),
                        contentDescription = "Skillora Logo",
                        modifier = Modifier.height(28.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "SKILLORA",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = BrandDark
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Create your account",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Full Name",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = fullName,
                    onValueChange = { fullName = it },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Full Name"
                        )
                    },
                    placeholder = { Text("Enter your full name") },
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = fieldColors()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Email",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email"
                        )
                    },
                    placeholder = { Text("Enter your email") },
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = fieldColors()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Create Password",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password"
                        )
                    },
                    placeholder = { Text("Password") },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(10.dp),
                    colors = fieldColors()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Confirm Password",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Confirm Password"
                        )
                    },
                    placeholder = { Text("Confirm Password") },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(10.dp),
                    colors = fieldColors()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Location",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = district,
                    onValueChange = { district = it },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location"
                        )
                    },
                    placeholder = { Text("Enter your district") },
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = fieldColors()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "I want to use Skillora to",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = { selectedOption = "offer" },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (selectedOption == "offer") {
                                    Icons.Default.RadioButtonChecked
                                } else {
                                    Icons.Default.RadioButtonUnchecked
                                },
                                contentDescription = null,
                                tint = BrandBlue
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Offer my skill/\nservice",
                                textAlign = TextAlign.Center,
                                color = if (selectedOption == "offer") BrandBlue else Color.Black
                            )
                        }
                    }

                    OutlinedButton(
                        onClick = { selectedOption = "find" },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (selectedOption == "find") {
                                    Icons.Default.RadioButtonChecked
                                } else {
                                    Icons.Default.RadioButtonUnchecked
                                },
                                contentDescription = null,
                                tint = BrandBlue
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Find service",
                                textAlign = TextAlign.Center,
                                color = if (selectedOption == "find") BrandBlue else Color.Black
                            )
                        }
                    }
                }

                if (errorMessage.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = {
                        errorMessage = when {
                            fullName.isBlank() -> "Please enter your full name"
                            email.isBlank() -> "Please enter your email"
                            !email.contains("@") -> "Please enter a valid email"
                            password.isBlank() -> "Please enter a password"
                            password.length < 6 -> "Password must be at least 6 characters"
                            confirmPassword.isBlank() -> "Please confirm your password"
                            password != confirmPassword -> "Passwords do not match"
                            district.isBlank() -> "Please enter your district"
                            else -> ""
                        }

                        if (errorMessage.isEmpty()) {
                            isLoading = true

                            scope.launch {
                                val success = FirebaseManager.registerUser(
                                    name = fullName,
                                    email = email,
                                    password = password,
                                    district = district,
                                    accountType = selectedOption
                                )

                                isLoading = false

                                if (success) {
                                    onCreateAccountClick()
                                } else {
                                    errorMessage = "Account creation failed. Please try again."
                                }
                            }
                        }
                    },
                    enabled = !isLoading,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = BrandBlue
                    )
                ) {
                    Text(
                        text = if (isLoading) "Creating Account..." else "Create Account",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "By creating an account you agree to Skillora's",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Black
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = "Terms of service & privacy policy",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = BrandBlue
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Already have an account",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    TextButton(onClick = onSignInClick) {
                        Text(
                            text = "Sign in",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = BrandDark
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun fieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = BrandBlue,
    unfocusedBorderColor = Color.Gray,
    focusedLeadingIconColor = BrandBlue,
    unfocusedLeadingIconColor = Color.Gray,
    focusedTrailingIconColor = BrandBlue,
    unfocusedTrailingIconColor = Color.Gray
)