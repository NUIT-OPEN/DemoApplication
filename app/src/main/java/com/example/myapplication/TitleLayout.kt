package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.LinearLayout


class TitleLayout(context: Context?, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.title, this)
        val b_back: Button = findViewById<View>(R.id.b_back) as Button
        b_back.setOnClickListener(OnClickListener {
            (getContext() as Activity).finish()
        })
    }
}
