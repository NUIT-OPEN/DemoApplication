package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var b_login: Button
    lateinit var et_username: EditText
    lateinit var et_password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        b_login = this.findViewById(R.id.b_login)
        et_username = this.findViewById(R.id.et_username)
        et_password = this.findViewById(R.id.et_password)

        b_login.setOnClickListener {
            Toast.makeText(this, String.format(
                "用户名：%s\n密码：%s", et_username.text, et_password.text
            ), Toast.LENGTH_SHORT).show()
        }
    }
}