
       package com.minimalistphone

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(40, 40, 40, 40)

        val phone = Button(this)
        phone.text = "Phone"

        phone.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL))
        }

        val messages = Button(this)
        messages.text = "Messages"

        messages.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_MAIN).apply {
                    addCategory(Intent.CATEGORY_APP_MESSAGING)
                }
            )
        }

        val contacts = Button(this)
        contacts.text = "Contacts"

        contacts.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_VIEW).apply {
                    type = "vnd.android.cursor.dir/contact"
                }
            )
        }

        val settings = Button(this)
        settings.text = "Settings"

        settings.setOnClickListener {
            startActivity(Intent(Settings.ACTION_SETTINGS))
        }

        layout.addView(phone)
        layout.addView(messages)
        layout.addView(contacts)
        layout.addView(settings)

        setContentView(layout)
    }
}
