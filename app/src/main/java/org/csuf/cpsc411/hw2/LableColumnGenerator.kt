package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

//Create vertical linear layout. Put 3 labels. First, last, ssn
class LableColumnGenerator(val ctx : Context) {

    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)


        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.BLUE)


        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F //Gets layout for every single label. Yellow part is the layout
        lbParams.topMargin = 5
        lbParams.bottomMargin = 5

        /////////////////////////////////////////////////////////////////////////////////////////////////
        var lbl = TextView(ctx)
        lbl.text = "Claim Title"
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(lbl, lbParams)

        ////////////////////////////////////////////////////////////////////////////////////////////////
        lbl = TextView(ctx)
        lbl.text = "Claim Date"
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(lbl, lbParams)
        ///////////////////////////////////////////////////////////////

        lbl = TextView(ctx)
        return layoutObj
    }
}