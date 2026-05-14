package com.example.silloramobileapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.silloramobileapp.R
import com.example.silloramobileapp.ui.theme.BrandBlue
import com.example.silloramobileapp.ui.theme.BrandDark

@Composable
fun ProfileScreen(
    onHomeClick: () -> Unit,
    onCategoriesClick: () -> Unit,
    onUploadClick: () -> Unit,
    onRequestsClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit
) {
    val context = androidx.compose.ui.platform.LocalContext.current

    var selectedTab by remember { mutableStateOf("profile") }
    var recommend by remember { mutableStateOf("yes") }
    var feedback by remember { mutableStateOf("") }

    val skills = listOf(
        "Web Design",
        "Graphic Design",
        "Logo Design",
        "UI/UX Design",
        "Branding"
    )

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
                    .navigationBarsPadding()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
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

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        imageVector = Icons.Default.NotificationsNone,
                        contentDescription = "Notifications",
                        tint = BrandDark,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { onNotificationClick() }
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "Profile",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(14.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF4F4F6), RoundedCornerShape(16.dp))
                        .border(1.dp, Color(0xFFBDBDBD), RoundedCornerShape(16.dp))
                        .padding(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_avatar),
                        contentDescription = "Profile picture",
                        modifier = Modifier
                            .size(84.dp)
                            .border(1.dp, Color.LightGray, CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Sandun Senanayake",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Freelance Web & Graphic Designer",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location",
                            tint = BrandBlue,
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Gampaha, LK",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.Gray
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = { android.widget.Toast.makeText(context, "Not Implemented Yet", android.widget.Toast.LENGTH_SHORT).show() },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BrandBlue)
                    ) {
                        Text(
                            text = "Edit Profile",
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(10.dp))
                            .border(1.dp, Color(0xFFD0D0D0), RoundedCornerShape(10.dp))
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        StatItem("32", "Jobs Completed")
                        StatItem("26", "Reviews")
                        StatItem("3+yr", "Experience")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        ProfileTab("Profile", selectedTab == "profile") { selectedTab = "profile" }
                        ProfileTab("Portfolio", selectedTab == "portfolio") { selectedTab = "portfolio" }
                        ProfileTab("Reviews", selectedTab == "reviews") { selectedTab = "reviews" }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Divider(color = Color.Gray.copy(alpha = 0.5f))

                    Spacer(modifier = Modifier.height(12.dp))

                    when (selectedTab) {
                        "profile" -> {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = "About me",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = "Hello! I'm Sandun, a freelance web and graphic designer with over 3 years of experience. I specialize in creating modern and visually appealing websites, logos, and branding materials. I'm dedicated to delivering high-quality work that helps businesses stand out. Let's work together to bring your vision to life!",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.DarkGray
                                    )
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = "Skills",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    skills.forEach { skill ->
                                        SkillChip(skill)
                                    }
                                }
                            }
                        }

                        "portfolio" -> {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = "Portfolio",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    PortfolioCard(
                                        imageRes = R.drawable.work_1,
                                        title = "Daily show logo",
                                        year = "2020"
                                    )

                                    PortfolioCard(
                                        imageRes = R.drawable.work_2,
                                        title = "Cleaning service logo",
                                        year = "2024"
                                    )
                                }

                                Spacer(modifier = Modifier.height(14.dp))

                                Button(
                                    onClick = { android.widget.Toast.makeText(context, "Not Implemented Yet", android.widget.Toast.LENGTH_SHORT).show() },
                                    modifier = Modifier
                                        .fillMaxWidth(0.8f)
                                        .align(Alignment.CenterHorizontally),
                                    shape = RoundedCornerShape(20.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent,
                                        contentColor = BrandBlue
                                    ),
                                    border = androidx.compose.foundation.BorderStroke(1.dp, BrandBlue),
                                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
                                ) {
                                    Text("See more")
                                }
                            }
                        }

                        "reviews" -> {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Would you recommend?",
                                        modifier = Modifier.weight(1f),
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )
                                    )

                                    Row(
                                        modifier = Modifier
                                            .background(Color(0xFFE0E0E0), RoundedCornerShape(16.dp))
                                            .padding(2.dp)
                                    ) {
                                        ReviewChoiceChip("Yes", recommend == "yes") { recommend = "yes" }
                                        ReviewChoiceChip("No", recommend == "no") { recommend = "no" }
                                    }
                                }

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = "Rate",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    repeat(5) {
                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Star",
                                            tint = Color(0xFFFFC107),
                                            modifier = Modifier.size(26.dp)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = "Your Feedback",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                OutlinedTextField(
                                    value = feedback,
                                    onValueChange = { feedback = it },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp),
                                    placeholder = {
                                        Text("Share details about your experience..............")
                                    },
                                    shape = RoundedCornerShape(6.dp),
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = Color.Gray,
                                        unfocusedBorderColor = Color.Gray
                                    )
                                )

                                Spacer(modifier = Modifier.height(14.dp))

                                Button(
                                    onClick = { android.widget.Toast.makeText(context, "Not Implemented Yet", android.widget.Toast.LENGTH_SHORT).show() },
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    shape = RoundedCornerShape(16.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = BrandBlue)
                                ) {
                                    Text(
                                        text = "Submit review",
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { android.widget.Toast.makeText(context, "Not Implemented Yet", android.widget.Toast.LENGTH_SHORT).show() },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BrandBlue)
                    ) {
                        Text(
                            text = "Contact me",
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                BottomNavBar(
                    selectedTab = "profile",
                    onHomeClick = onHomeClick,
                    onCategoriesClick = onCategoriesClick,
                    onUploadClick = onUploadClick,
                    onRequestsClick = onRequestsClick,
                    onProfileClick = onProfileClick
                )
            }
        }
    }
}

@Composable
fun ProfileTab(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Text(
        text = text,
        modifier = Modifier.clickable { onClick() },
        fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
        color = if (selected) Color.Black else Color.Gray
    )
}

@Composable
fun StatItem(number: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color.Gray
            )
        )
    }
}

@Composable
fun SkillChip(text: String) {
    Box(
        modifier = Modifier
            .background(Color(0xFFD7E7FA), RoundedCornerShape(20.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall.copy(
                color = BrandDark
            )
        )
    }
}

@Composable
fun PortfolioCard(
    imageRes: Int,
    title: String,
    year: String
) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .background(Color(0xFFD7E7FA), RoundedCornerShape(0.dp))
            .padding(bottom = 8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 6.dp),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = year,
            modifier = Modifier.padding(horizontal = 6.dp),
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "View Project",
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 6.dp),
            style = MaterialTheme.typography.bodySmall.copy(
                color = BrandBlue
            )
        )
    }
}

@Composable
fun ReviewChoiceChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                if (selected) Color(0xFFBDBDBD) else Color.Transparent,
                RoundedCornerShape(14.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            color = Color.DarkGray,
            style = MaterialTheme.typography.bodySmall
        )
    }
}