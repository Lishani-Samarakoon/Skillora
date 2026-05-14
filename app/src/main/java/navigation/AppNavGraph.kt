package com.example.silloramobileapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.silloramobileapp.ui.screens.CategoriesScreen
import com.example.silloramobileapp.ui.screens.CreativeDesignScreen
import com.example.silloramobileapp.ui.screens.DrawingIllustrationScreen
import com.example.silloramobileapp.ui.screens.HomeScreen
import com.example.silloramobileapp.ui.screens.IllustratorProfileScreen
import com.example.silloramobileapp.ui.screens.NotificationScreen
import com.example.silloramobileapp.ui.screens.ProfileScreen
import com.example.silloramobileapp.ui.screens.RequestScreen
import com.example.silloramobileapp.ui.screens.SignInScreen
import com.example.silloramobileapp.ui.screens.SignUpScreen
import com.example.silloramobileapp.ui.screens.UploadScreen
import com.example.silloramobileapp.ui.screens.WelcomeScreen

object Routes {
    const val WELCOME = "welcome"
    const val SIGN_IN = "sign_in"
    const val SIGN_UP = "sign_up"
    const val HOME = "home"
    const val CATEGORIES = "categories"
    const val CREATIVE_DESIGN = "creative_design"
    const val DRAWING_ILLUSTRATION = "drawing_illustration"
    const val ILLUSTRATOR_PROFILE = "illustrator_profile"
    const val UPLOAD = "upload"
    const val REQUESTS = "requests"
    const val PROFILE = "profile"
    const val NOTIFICATIONS = "notifications"
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.WELCOME
    ) {
        composable(Routes.WELCOME) {
            WelcomeScreen(
                onGetStartedClick = {
                    navController.navigate(Routes.SIGN_IN)
                }
            )
        }

        composable(Routes.SIGN_IN) {
            SignInScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSignUpClick = {
                    navController.navigate(Routes.SIGN_UP)
                },
                onSignInClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.SIGN_IN) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.SIGN_UP) {
            SignUpScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSignInClick = {
                    navController.popBackStack()
                },
                onCreateAccountClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.SIGN_IN) { inclusive = false }
                    }
                }
            )
        }

        composable(Routes.HOME) {
            HomeScreen(
                onHomeClick = { },
                onCategoriesClick = {
                    navController.navigate(Routes.CATEGORIES)
                },
                onUploadClick = {
                    navController.navigate(Routes.UPLOAD)
                },
                onRequestsClick = {
                    navController.navigate(Routes.REQUESTS)
                },
                onProfileClick = {
                    navController.navigate(Routes.PROFILE)
                },
                onNotificationClick = {
                    navController.navigate(Routes.NOTIFICATIONS)
                }
            )
        }

        composable(Routes.CATEGORIES) {
            CategoriesScreen(
                onHomeClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                onCategoriesClick = { },
                onUploadClick = {
                    navController.navigate(Routes.UPLOAD)
                },
                onRequestsClick = {
                    navController.navigate(Routes.REQUESTS)
                },
                onProfileClick = {
                    navController.navigate(Routes.PROFILE)
                },
                onNotificationClick = {
                    navController.navigate(Routes.NOTIFICATIONS)
                },
                onCreativeDesignClick = {
                    navController.navigate(Routes.CREATIVE_DESIGN)
                }
            )
        }

        composable(Routes.CREATIVE_DESIGN) {
            CreativeDesignScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onHomeClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                onCategoriesClick = {
                    navController.navigate(Routes.CATEGORIES) {
                        popUpTo(Routes.CATEGORIES) { inclusive = true }
                    }
                },
                onUploadClick = {
                    navController.navigate(Routes.UPLOAD)
                },
                onRequestsClick = {
                    navController.navigate(Routes.REQUESTS)
                },
                onProfileClick = {
                    navController.navigate(Routes.PROFILE)
                },
                onNotificationClick = {
                    navController.navigate(Routes.NOTIFICATIONS)
                },
                onDrawingIllustrationClick = {
                    navController.navigate(Routes.DRAWING_ILLUSTRATION)
                }
            )
        }

        composable(Routes.DRAWING_ILLUSTRATION) {
            DrawingIllustrationScreen(
                onHomeClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                onCategoriesClick = {
                    navController.navigate(Routes.CATEGORIES)
                },
                onUploadClick = {
                    navController.navigate(Routes.UPLOAD)
                },
                onRequestsClick = {
                    navController.navigate(Routes.REQUESTS)
                },
                onProfileClick = {
                    navController.navigate(Routes.PROFILE)
                },
                onNotificationClick = {
                    navController.navigate(Routes.NOTIFICATIONS)
                },
                onIllustratorProfileClick = {
                    navController.navigate(Routes.ILLUSTRATOR_PROFILE)
                }
            )
        }

        composable(Routes.ILLUSTRATOR_PROFILE) {
            IllustratorProfileScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onHomeClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                onCategoriesClick = {
                    navController.navigate(Routes.CATEGORIES)
                },
                onUploadClick = {
                    navController.navigate(Routes.UPLOAD)
                },
                onRequestsClick = {
                    navController.navigate(Routes.REQUESTS)
                },
                onProfileClick = {
                    navController.navigate(Routes.PROFILE)
                },
                onNotificationClick = {
                    navController.navigate(Routes.NOTIFICATIONS)
                }
            )
        }

        composable(Routes.UPLOAD) {
            UploadScreen(
                onHomeClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                onCategoriesClick = {
                    navController.navigate(Routes.CATEGORIES)
                },
                onUploadClick = { },
                onRequestsClick = {
                    navController.navigate(Routes.REQUESTS)
                },
                onProfileClick = {
                    navController.navigate(Routes.PROFILE)
                },
                onNotificationClick = {
                    navController.navigate(Routes.NOTIFICATIONS)
                }
            )
        }

        composable(Routes.REQUESTS) {
            RequestScreen(
                onHomeClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                onCategoriesClick = {
                    navController.navigate(Routes.CATEGORIES)
                },
                onUploadClick = {
                    navController.navigate(Routes.UPLOAD)
                },
                onRequestsClick = { },
                onProfileClick = {
                    navController.navigate(Routes.PROFILE)
                },
                onNotificationClick = {
                    navController.navigate(Routes.NOTIFICATIONS)
                }
            )
        }

        composable(Routes.PROFILE) {
            ProfileScreen(
                onHomeClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                onCategoriesClick = {
                    navController.navigate(Routes.CATEGORIES)
                },
                onUploadClick = {
                    navController.navigate(Routes.UPLOAD)
                },
                onRequestsClick = {
                    navController.navigate(Routes.REQUESTS)
                },
                onProfileClick = { },
                onNotificationClick = {
                    navController.navigate(Routes.NOTIFICATIONS)
                }
            )
        }

        composable(Routes.NOTIFICATIONS) {
            NotificationScreen(
                onHomeClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                onCategoriesClick = {
                    navController.navigate(Routes.CATEGORIES)
                },
                onUploadClick = {
                    navController.navigate(Routes.UPLOAD)
                },
                onRequestsClick = {
                    navController.navigate(Routes.REQUESTS)
                },
                onProfileClick = {
                    navController.navigate(Routes.PROFILE)
                },
                onNotificationClick = { } // Intentionally empty
            )
        }
    }
}