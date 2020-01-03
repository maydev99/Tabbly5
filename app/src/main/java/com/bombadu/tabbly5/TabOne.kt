package com.bombadu.tabbly5

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

class TabOne : Fragment() {
    var isTextColor = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tab1, container, false)
        val oneTextView = view.findViewById<TextView>(R.id.oneTextView)
        oneTextView.setOnClickListener {
            isTextColor = if (!isTextColor) {
                oneTextView.setTextColor(Color.RED)
                true
            } else {
                oneTextView.setTextColor(Color.BLACK)
                false
            }
        }
        val myCities = arrayOf("New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Detroit", "Jacksonville", "Indianapolis", "San Francisco", "Columbus", "Austin", "Memphis", "Fort Worth", "Baltimore", "Charlotte", "El Paso", "Boston", "Seattle")

        val listView = view.findViewById<ListView>(R.id.listView)
        val myAdapter = ArrayAdapter<String>(view.context, android.R.layout.simple_list_item_1, myCities)
        listView.adapter = myAdapter

        return view
    }
}