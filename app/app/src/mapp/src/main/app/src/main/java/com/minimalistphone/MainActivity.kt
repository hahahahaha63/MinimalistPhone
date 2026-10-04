package com.minimalistphone

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)

        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(40, 60, 40, 40)

        val phone = Button(this)
        phone.text = "Phone"

        phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }

        val messages = Button(this)
        messages.text = "Messages"

        messages.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_APP_MESSAGING)
            startActivity(intent)
        }

        val contacts = Button(this)
        contacts.text = "Contacts"

        contacts.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.type = "vnd.android.cursor.dir/contact"
            startActivity(intent)
        }

        val settings = Button(this)
        settings.text = "Settings"

        settings.setOnClickListener {
            val intent = Intent(Settings.ACTION_SETTINGS)
            startActivity(intent)
        }

        layout.addView(phone)
        layout.addView(messages)
        layout.addView(contacts)
        layout.addView(settings)

        setContentView(layout)
    }
}

