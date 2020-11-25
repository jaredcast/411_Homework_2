/*package org.csuf.cpsc411.simplehttpclient

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView

class CustomAdapter (val cService : ClaimService): BaseAdapter() {

    var editMode : Boolean = false
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View { //Create a view for the screen. Adapter managing the data
        val claimObj = cService.claimList[position]
        val root = LinearLayout(parent?.context)
        val rParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        root.setLayoutParams(rParams)
        root.orientation = LinearLayout.HORIZONTAL

        val chkbx = CheckBox(parent?.context)
        val cbParams = LinearLayout.LayoutParams( //Use linear layout here, wrap content
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        chkbx.setOnClickListener() {
            if ((it as CheckBox).isChecked) cService.claimList[position].toBeDeleted  //Determine if checked
            else cService.claimList[position].toBeDeleted = false
        }

        if (editMode) chkbx.visibility = View.VISIBLE
        else chkbx.visibility = View.GONE

        root.addView(chkbx, cbParams)

        //val label = "${claimObj.id} ${claimObj.date}"
        val lblView = TextView(parent?.context)
        //lblView.text = label
        val lbParams = LinearLayout.LayoutParams( //Use linear layout here, wrap content
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        root.addView(lblView, lbParams)

        return root
    }

    override fun getItem(position: Int): Any {
        return cService.claimList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return cService.claimList.size
    }

    fun updateData() {
        cService.getAll()
        this.notifyDataSetChanged()
    }

}*/