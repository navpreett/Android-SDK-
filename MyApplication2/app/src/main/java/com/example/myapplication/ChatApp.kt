package com.example.myapplication

import android.app.Application
import com.amity.socialcloud.sdk.api.core.AmityCoreClient
import com.amity.socialcloud.sdk.api.core.endpoint.AmityEndpoint

class ChatApp : Application() {

    override fun onCreate() {
        super.onCreate()

        setupWithCustomEndPoint()
    }

        private fun setupWithCustomEndPoint() {
            AmityCoreClient.setup(
                apiKey = "b0efe90c3bdda2304d628918520c1688845889e4bc363d2c",
                endpoint = AmityEndpoint.CUSTOM(
                    httpEndpoint = "httpUrl",
                    socketEndpoint = "socketUrl",
                    mqttEndpoint = "mqttUrl"
                )
        )
    }
}


