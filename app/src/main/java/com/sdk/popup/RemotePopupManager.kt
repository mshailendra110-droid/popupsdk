package com.sdk.popup

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Button
import android.widget.TextView

object RemotePopupManager {

    fun showPopup(
        context: Context,
        data: PopupData
    ) {

        val dialog = Dialog(context)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.popup_layout)

        val tvTitle = dialog.findViewById<TextView>(R.id.tvTitle)
        val tvMessage = dialog.findViewById<TextView>(R.id.tvMessage)
        val btnAction = dialog.findViewById<Button>(R.id.btnAction)

        tvTitle.text = data.title
        tvMessage.text = data.message
        btnAction.text = data.buttonText

        btnAction.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}