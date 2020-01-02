package com.bombadu.tabbly5

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TabThree : Fragment() {
    var isTextColor = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tab3, container, false)
        val threeTextView = view.findViewById<TextView>(R.id.threeTextView)
        threeTextView.setOnClickListener {
            isTextColor = if (!isTextColor) {
                threeTextView.setTextColor(Color.BLUE)
                true
            } else {
                threeTextView.setTextColor(Color.BLACK)
                false
            }
        }
        return view
    }
}