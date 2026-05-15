# PopupSDK

Lightweight Android SDK to show remote popups dynamically using JSON data.

## Installation

Add JitPack in `settings.gradle`

```kotlin
maven { url = uri("https://jitpack.io") }

Add dependency
implementation("com.github.mshailendra110-droid:popupsdk:1.0.5")

Usage

fun fetchRemotePopup() {

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

        RemotePopupManager.showPopup(context, data)

    } catch (e: Exception) {
        e.printStackTrace()
    }
}


