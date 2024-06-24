//package com.example.myapplication
//
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.amity.socialcloud.sdk.api.core.AmityCoreClient
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import com.amity.socialcloud.sdk.api.core.endpoint.AmityEndpoint
//import com.google.android.gms.auth.api.Auth
//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        AmityCoreClient.setup(
//            apiKey = "apikey",
//            endpoint = AmityEndpoint.EU // optional param, defaulted as SG region
//        )
//        setContent {
//            LoginLogoutScreen()
//        }
//    }
//}
//
//@Composable
//fun LoginLogoutScreen() {
//    var loggedIn by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        if (!loggedIn) {
//            Button(
//                onClick = {
//                    authenticate("userId 1") {
//                        loggedIn = true
//                    }
//                },
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text("Login")
//            }
//        } else {
//            Button(
//                onClick = {
//                    logout {
//                        loggedIn = false
//                    }
//                },
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text("Logout")
//            }
//        }
//    }
//}
//
//fun authenticate(userId: String, onSuccess: () -> Unit) {
//    val authManager = AmityCoreClient.newAuthManager()
//    authManager.login(
//        Auth.builder()
//            .userId(userId)
//            .displayName("John Doe") // optional
//            .authToken("token") // optional
//            .build(),
//        object : AuthHandler.SessionHandler {
//            override fun onSuccess(authManager: AuthManager) {
//                onSuccess()
//            }
//
//            override fun onError(error: AuthHandler.Error) {
//                // Handle login error
//            }
//        })
//}
//
//fun logout(onSuccess: () -> Unit) {
//    val authManager = AmityCoreClient.newAuthManager()
//    authManager.logout(object : AuthHandler.SessionHandler {
//        override fun onSuccess(authManager: AuthManager) {
//            onSuccess()
//        }
//
//        override fun onError(error: AuthHandler.Error) {
//            // Handle logout error
//        }
//    })
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    LoginLogoutScreen()
//}
