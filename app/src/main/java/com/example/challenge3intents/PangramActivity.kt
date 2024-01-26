/**
 * James Hamilton
 * January 25th, 2024
 * ADEV 3007: Zacharie Montreuil
 */

package com.example.challenge3intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PangramActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pangram)

        // Get the textView.
        val textViewPangram : TextView = findViewById(R.id.textViewPangram)

        // Get the text from the intent.
        val intentText : String? = intent.getStringExtra("text")

        if (intentText == null || intentText == "")
        {
            textViewPangram.text = "No text was passed in. Please enter text."
        }
        else if (intentText.length < 3)
        {
            textViewPangram.text = "You must enter more than 2 characters."
        }
        else if (isPangram(intentText))
        {
            textViewPangram.text = String.format("%s is a pangram. :)", intentText)
        }
        else
        {
            textViewPangram.text = String.format("Sorry %s is not a pangram. Please try again!", intentText)
        }

        // Add back button functionality.
        val buttonBackPangram : Button = findViewById(R.id.buttonBackPangram)

        buttonBackPangram.setOnClickListener()
        {
            val backPangramIntent = Intent(this@PangramActivity, MainActivity::class.java)

            startActivity(backPangramIntent)
        }
    }

    /**
     * Checks if an inputted string is a pangram or not.
     *
     * @param str The string to be checked.
     * @return True if the string is a Pangram, False if not.
     */
    fun isPangram(str : String) : Boolean
    {
        val alphabet = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                              'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                              'u', 'v', 'w', 'x', 'y', 'z')

        for (index in alphabet)
        {
            if (index !in str.lowercase())
            {
                return false
            }

        }

        return true
    }
}