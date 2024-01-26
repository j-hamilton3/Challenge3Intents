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

class PalindromeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palindrome)

        // Get the textView.
        val textViewPalindrome : TextView = findViewById(R.id.textViewPalindrome)

        // Get the text from the intent.
        val intentText : String? = intent.getStringExtra("text")

        if (intentText == null || intentText == "")
        {
            textViewPalindrome.text = "No text was passed in. Please enter text."
        }
        else if (intentText.length < 3)
        {
            textViewPalindrome.text = "You must enter more than 2 characters."
        }
        else if (isPalindrome(intentText))
        {
            textViewPalindrome.text = String.format("%s is a palindrome. :)", intentText)
        }
        else
        {
            textViewPalindrome.text = String.format("%s is not a palindrome. Please try again!", intentText)
        }

        // Add back button functionality.
        val buttonBackPalindrome : Button = findViewById(R.id.buttonBackPalindrome)

        buttonBackPalindrome.setOnClickListener()
        {
            val backPalindromeIntent = Intent(this@PalindromeActivity, MainActivity::class.java)

            startActivity(backPalindromeIntent)
        }
    }

    /**
     * Checks if an inputted string is a Palindrome or not.
     *
     * @param str The string to check.
     * @return True if it is a Palindrome, false if not.
     */
    fun isPalindrome(str : String) : Boolean
    {
        return str.lowercase() == str.lowercase().reversed()
    }
}