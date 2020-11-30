package org.csuf.cpsc411.hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.csuf.cpsc411.simplehttpclient.*
import java.util.*


//Homework Assignment 2, this constructs main screen
open class MainActivity : AppCompatActivity() {
    // lateinit var pList : MutableList<Person>
    lateinit var cService : ClaimService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)
        cService = ClaimService.getInstance(this)

        val statusText: TextView = findViewById(R.id.status_text)

        val bView : Button = findViewById(R.id.add_btn)

        bView.setOnClickListener() {
            // get the next Person object
            // then refresh screen
            var tempTitle : EditText = findViewById(R.id.claimTitle) //Title of claim
            var tempDate : EditText = findViewById(R.id.date) //Date of claim

            var claimTitleStr = tempTitle.text.toString() //Set the claim title
            var dateStr = tempDate.text.toString() //Set the claim date

<<<<<<< HEAD

            if (claimTitleStr == "" || dateStr == "") { //If any field is blank
=======
            if (claimTitleStr == "" || dateStr == "") {
>>>>>>> parent of aa37f47... Clean up code
                statusText.text = "Status: Cannot be blank, try again."
            }
            else {
                var newClaim = Claim(UUID.randomUUID(), claimTitleStr, dateStr, false) //Create new string
                cService.addClaim(newClaim) //Add claim with cService
                if (cService.isOnline == false) //If offline, let user know
                {
                    Log.d("MainActivity", "Failed")
                    statusText.text = "Status: failed to add claim"
                }
                else { //Add claim
                    Log.d("MainActivity", "Added ${claimTitleStr} and ${dateStr}")
                    tempTitle.text.clear()
                    tempDate.text.clear()
                    statusText.text = "Status: Claim ${claimTitleStr} successfully added."
                }
            }
        }
    }
}

