package com.example.silloramobileapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

data class CreativeDesignItem(
    val title: String,
    val subtitle: String,
    val imageRes: Int
)

@Composable
fun CreativeDesignScreen(
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    onCategoriesClick: () -> Unit,
    onUploadClick: () -> Unit,
    onRequestsClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onDrawingIllustrationClick: () -> Unit
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val items = listOf(
        CreativeDesignItem(
            title = "Drawing & Illustration",
            subtitle = "Custom drawing, digital art",
            imageRes = R.drawable.creative_design_1
        ),
        CreativeDesignItem(
            title = "UI / UX Designs",
            subtitle = "App & Website Interface designs",
            imageRes = R.drawable.creative_design_2
        ),
        CreativeDesignItem(
            title = "Logo & Brand Design",
            subtitle = "Logos, Branding & Identity Kits",
            imageRes = R.drawable.creative_design_3
        )
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

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = BrandDark,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { onBackClick() }
                    )

                    Spacer(modifier = Modifier.width(14.dp))

                    Text(
                        text = "Creative & Design",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                items.forEach { item ->
                    CreativeDesignCard(
                        item = item,
                        onClick = {
                            if (item.title == "Drawing & Illustration") {
                                onDrawingIllustrationClick()
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { android.widget.Toast.makeText(context, "Not Implemented Yet", android.widget.Toast.LENGTH_SHORT).show() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = BrandBlue
                    ),
                    border = BorderStroke(1.dp, BrandBlue),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircleOutline,
                        contentDescription = "Post a Designs",
                        tint = Color(0xFF8A5AA5)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Post a Designs",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = BrandBlue
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                BottomNavBar(
                    selectedTab = "categories",
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
fun CreativeDesignCard(
    item: CreativeDesignItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD9E7FA))
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .width(96.dp)
                    .height(134.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.subtitle,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(18.dp))

                Button(
                    onClick = onClick,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BrandBlue)
                ) {
                    Text(
                        text = "View Designs",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}