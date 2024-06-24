package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.amity.socialcloud.sdk.api.core.AmityCoreClient
import com.amity.socialcloud.sdk.api.core.endpoint.AmityEndpoint

// Commenting out the import for GlobalFeedActivity for now
// import GlobalFeedActivity

class MainFragment : Fragment() {

    private lateinit var usernameInput: EditText
    private lateinit var loginButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = RelativeLayout(requireContext())

        usernameInput = EditText(requireContext()).apply {
            id = View.generateViewId()
            hint = "Enter your name"
        }

        val usernameParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
            setMargins(0, 0, 0, 100)
        }

        loginButton = Button(requireContext()).apply {
            id = View.generateViewId()
            text = "Login"
        }

        val buttonParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            addRule(RelativeLayout.BELOW, usernameInput.id)
            addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
        }

        layout.addView(usernameInput, usernameParams)
        layout.addView(loginButton, buttonParams)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AmityCoreClient.setup(
            apiKey = "b0efe90c3bdda2304d628918520c1688845889e4bc363d2c",
            endpoint = AmityEndpoint.SG
        )

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            if (username.isNotEmpty()) {
                // Commented out the intent for GlobalFeedActivity
                /*
                val intent = Intent(requireContext(), GlobalFeedActivity::class.java).apply {
                    putExtra("USERNAME", username)
                }
                startActivity(intent)
                */
                // Simulate successful login (for now, you can replace this with actual logic)
                // For example, navigating to another fragment or activity
                // findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
            } else {
                usernameInput.error = "Please enter your name"
            }
        }
    }
}
