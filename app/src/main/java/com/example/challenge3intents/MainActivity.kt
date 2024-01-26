/**
 * James Hamilton
 * January 25th, 2024
 * ADEV 3007: Zacharie Montreuil
 */

package com.example.challenge3intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get buttons by Id.
        val buttonPangram : Button = findViewById(R.id.buttonPangram)
        val buttonPalindrome : Button = findViewById(R.id.buttonPalindrome)

        // Get text field value.
        val homeTextInput : TextInputEditText = findViewById(R.id.homeTextInput)

        // Add event listeners to the buttons.
        buttonPangram.setOnClickListener()
        {
            val pangramIntent = Intent(this@MainActivity, PangramActivity::class.java)

            val text: String = homeTextInput.text.toString()
            pangramIntent.putExtra("text", text)

            startActivity(pangramIntent)
        }

        buttonPalindrome.setOnClickListener()
        {
            val palindromeIntent = Intent(this@MainActivity, PalindromeActivity::class.java)

            val text: String = homeTextInput.text.toString()
            palindromeIntent.putExtra("text", text)

            startActivity(palindromeIntent)
        }
    }
}