package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import org.csuf.cpsc411.hw2.R


class ObjDetailScreenGenerator(val ctx : Context) {
    // Create a linearlayout object
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        layoutObj = LinearLayout(ctx)


        ///////////////////////////////////////////////////////////////////////////////////
        //Create a new linear layout for top text asking for claim info

        val textParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        textParams.topMargin = 70
        textParams.bottomMargin = 70
        var title = TextView(ctx)
        title.text = "Please Enter Claim Information"
        title.gravity = Gravity.CENTER
        title.textSize = 20f
        title.setTextColor(Color.BLACK)
        // add TextView to LinearLayout
        layoutObj.addView(title, textParams)

        ///////////////////////////////////////////////////////////////////////////////////
        //Generate the objects needed - fldRowGenerator and colView.
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)

        // Add objdetail section
        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView) //Add most of project to screen
        ///////////////////////////////////////////////////////////////////////////////////
        // add next button linear layout
        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, //we wrap content . Adding the linear layout object vertically to the other vertical object. Can apply gravity to the linear layout object
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        /*nParams.gravity = Gravity.BOTTOM
        nParams.weight = 1.0F
        nParams.weight = 0.0F //Weight reset*/
        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
        nLayout.setBackgroundColor(Color.RED)
        //
        ///////////////////////////////////////////////////////////////////////////////////
        //Create a new linear layout for add button
        val addButton = Button(ctx) //No more elements ? Disable button.
        addButton.text = "ADD"
        addButton.setId(R.id.add_btn)
        addButton.setBackgroundColor(Color.CYAN)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.gravity = Gravity.BOTTOM
        nLayout.addView(addButton, nbParams)
        //
        layoutObj.addView(nLayout) //Button has been added

        ///////////////////////////////////////////////////////////////////////////////////


        //Create a new linear layout for Status. This will change later
        val statusObj = LinearLayout(ctx)
        val statusParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        statusParams.topMargin = 70
        statusParams.bottomMargin = 70
        var status = TextView(ctx)
        status.setId(R.id.status_text) //IMPORTANT< MAKE SURE THIS IS REFERENCED IN MAINACTIVITY
        status.text = "Status: "
        status.gravity = Gravity.CENTER
        status.textSize = 20f
        status.setTextColor(Color.BLACK)

        // add TextView to LinearLayout
        statusObj.addView(status, statusParams)
        layoutObj.addView(statusObj)

        return layoutObj
    }


}

/*val statusParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        var status = TextView(ctx)
        title.text = "Status: "
        title.textSize = 20f
        title.setTextColor(Color.BLACK)
        // add TextView to LinearLayout
        nLayout.addView(status, statusParams)*/
