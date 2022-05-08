package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    lateinit var b_done: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        b_done = this.findViewById(R.id.b_done)
        b_done.setOnClickListener {
            val intent = Intent()
            intent.putExtra("return", "我回传一本给你")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}