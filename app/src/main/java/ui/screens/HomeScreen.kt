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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.silloramobileapp.R
import com.example.silloramobileapp.ui.theme.BrandBlue
import com.example.silloramobileapp.ui.theme.BrandDark

data class FeaturedWork(
    val category: String,
    val imageRes: Int,
    val personName: String,
    val rating: String
)

@Composable
fun HomeScreen(
    onHomeClick: () -> Unit,
    onCategoriesClick: () -> Unit,
    onUploadClick: () -> Unit,
    onRequestsClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit
) {
    val context = androidx.compose.ui.platform.LocalContext.current

    val featuredWorks = remember {
        listOf(
            FeaturedWork("Creative & Design", R.drawable.work_1, "Nuwan Perera", "4.5"),
            FeaturedWork("Craft & Handmade", R.drawable.work_2, "Chathumini Silva", "4.4"),
            FeaturedWork("Events & Personal Services", R.drawable.work_3, "Imani Rathnayake", "4.9"),
            FeaturedWork("IT & Tech Services", R.drawable.work_4, "Saman Peris", "4.8")
        )
    }

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
                    .padding(horizontal = 14.dp, vertical = 12.dp)
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

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Find Skilled Professionals",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                    placeholder = {
                        Text("Search skills or services")
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray,
                        disabledBorderColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                Image(
                    painter = painterResource(id = R.drawable.hero_people),
                    contentDescription = "Hero People",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Featured Works",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(featuredWorks) { work ->
                        FeaturedWorkCard(item = work)
                    }

                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                onClick = { android.widget.Toast.makeText(context, "Not Implemented Yet", android.widget.Toast.LENGTH_SHORT).show() },
                                shape = RoundedCornerShape(20.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = BrandBlue
                                ),
                                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
                                border = BorderStroke(1.dp, BrandBlue)
                            ) {
                                Text("See more")
                            }
                        }
                    }
                }

                BottomNavBar(
                    selectedTab = "home",
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
fun FeaturedWorkCard(item: FeaturedWork) {
    Card(
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = item.category,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(96.dp),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .background(BrandBlue, RoundedCornerShape(8.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = item.category,
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }

            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = item.personName,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "★★★★★  ${item.rating}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color(0xFFB8860B)
                    )
                )
            }
        }
    }
}

@Composable
fun BottomNavBar(
    selectedTab: String,
    onHomeClick: () -> Unit,
    onCategoriesClick: () -> Unit,
    onUploadClick: () -> Unit,
    onRequestsClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem("Home", Icons.Default.Home, selectedTab == "home", onHomeClick)
        BottomNavItem("Categories", Icons.Default.GridView, selectedTab == "categories", onCategoriesClick)
        BottomNavItem("Upload", Icons.Default.Upload, selectedTab == "upload", onUploadClick)
        BottomNavItem("Requests", Icons.Default.Description, selectedTab == "requests", onRequestsClick)
        BottomNavItem("Profile", Icons.Default.AccountCircle, selectedTab == "profile", onProfileClick)
    }
}

@Composable
fun BottomNavItem(
    label: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) BrandBlue else Color(0xFF3DA5F4),
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = if (selected) BrandBlue else Color(0xFF3DA5F4)
        )
    }
}