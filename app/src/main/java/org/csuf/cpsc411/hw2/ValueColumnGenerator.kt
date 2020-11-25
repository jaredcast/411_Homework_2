package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import org.csuf.cpsc411.hw2.R

//Adds the 3 added blocks. Edit text blocks
class ValueColumnGenerator(val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.topMargin = 5
        ////////////////////////////////////////////////////////////////////////////////////////////

        var value = EditText(ctx)
        value.id = R.id.claimTitle
        value.setHint("Enter Claim Name") //Tells user what you can do with this box
        value.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(value, vParams)

        ///////////////////////////////////////////////////////////////////////////////////////////////
        value = EditText(ctx)
        value.id = R.id.date
        value.setHint("Enter Date")
        value.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(value, vParams)
        return layoutObj
    }


}