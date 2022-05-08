package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class FirstActivity : AppCompatActivity() {
    var msg: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        msg = this.intent.getStringExtra("msg")
        if (msg != null)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}