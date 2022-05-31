package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class StorageAddActivity : AppCompatActivity() {
    lateinit var et_title: EditText
    lateinit var et_description: EditText
    lateinit var b_cancel: Button
    lateinit var b_confirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage_add)

        et_title = this.findViewById(R.id.et_title)
        et_description = this.findViewById(R.id.et_description)

        b_cancel = this.findViewById(R.id.b_cancel)
        b_cancel.setOnClickListener {
            finish()
        }

        b_confirm = this.findViewById(R.id.b_confirm)
        b_confirm.setOnClickListener {
            val posts = FileUtil.loadPosts(this)
            posts.add(
                Post(
                    et_title.text.toString(),
                    et_description.text.toString(),
                )
            )
            FileUtil.savePosts(this, posts)

            saveTemplate()

            setResult(Activity.RESULT_OK)
            finish()
        }

        loadTemplate()
    }

    @SuppressLint("CommitPrefEdits")
    fun saveTemplate() {
        val sp = getSharedPreferences("template", MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("title", et_title.text.toString())
        editor.putString("description", et_description.text.toString())
        editor.apply()
    }

    fun loadTemplate() {
        val sp = getSharedPreferences("template", MODE_PRIVATE)
        et_title.setText(sp.getString("title", ""))
        et_description.setText(sp.getString("description", ""))
    }
}