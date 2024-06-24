package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import com.amity.socialcloud.sdk.api.core.AmityCoreClient
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(color = MaterialTheme.colors.background) {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    // State for user inputs
    val userIdState = remember { mutableStateOf(TextFieldValue()) }
    val authTokenState = remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Login", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.padding(8.dp))

        // User ID TextField
        TextField(
            value = userIdState.value,
            onValueChange = { userIdState.value = it },
            label = { Text("User ID") }
        )
        Spacer(modifier = Modifier.padding(8.dp))

        // AuthToken TextField
        TextField(
            value = authTokenState.value,
            onValueChange = { authTokenState.value = it },
            label = { Text("Auth Token (Optional)") }
        )
        Spacer(modifier = Modifier.padding(16.dp))

        // Login Button
        Button(
            onClick = {
                val userId = userIdState.value.text.trim()
                val authToken = authTokenState.value.text.trim()
                loginWithAmitySDK(userId, authToken)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}

private fun loginWithAmitySDK(userId: String, authToken: String) {
    AmityCoreClient.login(userId = userId)
        .authToken(authToken = authToken)
        .build()
        .submit()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            // login successful, navigate to the next screen
            // navigateToMainScreen()
        }, { error ->
            //error handel
            error.printStackTrace()
        })
}
