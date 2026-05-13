package com.sdk.popup

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fetchRemotePopup()
    }

    private fun fetchRemotePopup() {

        // Simulated remote JSON
        val json = """
            {
                "title":"Special Offer",
                "message":"Get 50% OFF today!",
                "buttonText":"Claim Now"
            }
        """.trimIndent()

        try {

            val obj = JSONObject(json)

            val data = PopupData(
                title = obj.getString("title"),
                message = obj.getString("message"),
                buttonText = obj.getString("buttonText")
            )

            RemotePopupManager.showPopup(this, data)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}