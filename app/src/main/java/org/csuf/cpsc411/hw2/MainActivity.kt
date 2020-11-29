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
            var tempTitle : EditText = findViewById(R.id.claimTitle)
            var tempDate : EditText = findViewById(R.id.date)

            var claimTitleStr = tempTitle.text.toString()
            var dateStr = tempDate.text.toString()

            if (cService.isOnline == false)
            {
                statusText.text = "Status: Error, database is offline."
            }
            else if (claimTitleStr == "" || dateStr == "") {
                statusText.text = "Status: Cannot be blank, try again."
            }
            /*if (claimTitleStr == "" || dateStr == "") {
                statusText.text = "Status: Cannot be blank, try again."
            }*/
            else {
                var newClaim = Claim(UUID.randomUUID(), claimTitleStr, dateStr, false)
                cService.addClaim(newClaim)
                if (cService.isOnline == false)
                {
                    Log.d("MainActivity", "Failed")
                    statusText.text = "Status: failed to add claim"
                }
                else {
                    Log.d("MainActivity", "Added ${claimTitleStr} and ${dateStr}")
                    tempTitle.text.clear()
                    tempDate.text.clear()
                    statusText.text = "Status: Claim ${claimTitleStr} successfully added."
                }
            }
        }
    }
}

