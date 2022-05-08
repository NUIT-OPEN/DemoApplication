package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var b_test: Button
    lateinit var b_first: Button
    lateinit var b_first_msg: Button
    lateinit var b_baidu: Button
    lateinit var b_call: Button
    lateinit var b_third: Button
    lateinit var b_layout: Button
    lateinit var b_custom_view: Button
    lateinit var b_list: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        b_test = this.findViewById<Button>(R.id.b_test)
        b_test.setOnClickListener {
            Toast.makeText(this, "you click me", Toast.LENGTH_SHORT).show()
        }

        b_first = this.findViewById<Button>(R.id.b_first)
        b_first.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, FirstActivity::class.java)
            startActivity(intent);
        }

        b_first_msg = this.findViewById<Button>(R.id.b_first_msg)
        b_first_msg.setOnClickListener {
            val intent = Intent()
            intent.putExtra("msg", "hello FirstActivity,i am MainActivity")
            intent.setClass(this, FirstActivity::class.java)
            startActivity(intent);
        }

        b_baidu = this.findViewById<Button>(R.id.b_baidu)
        b_baidu.setOnClickListener {
            val intent = Intent()
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://baidu.com")
            startActivity(intent);
        }

        b_call = this.findViewById<Button>(R.id.b_call)
        b_call.setOnClickListener {
            val intent = Intent();
            intent.addCategory(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:12345")
            startActivity(intent)
        }

        b_third = this.findViewById<Button>(R.id.b_third)
        b_third.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, ThirdActivity::class.java)
            startActivityIfNeeded(intent, 1);
        }

        b_layout = this.findViewById<Button>(R.id.b_layout)
        b_layout.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, LayoutActivity::class.java)
            startActivity(intent)
        }

        b_custom_view = this.findViewById<Button>(R.id.b_custom_view)
        b_custom_view.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, CustomViewActivity::class.java)
            startActivity(intent)
        }

        b_list = this.findViewById<Button>(R.id.b_list)
        b_list.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, ListActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        if (item.itemId == R.id.m_login) {
            val intent = Intent()
            intent.setClass(this, LoginActivity::class.java)
            startActivity(intent)
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val returnData = data?.getStringExtra("return")
            Toast.makeText(this, returnData, Toast.LENGTH_SHORT).show()
        }
    }
}