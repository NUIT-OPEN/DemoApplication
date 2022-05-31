package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StorageHomeActivity : AppCompatActivity() {
    lateinit var fab_add: FloatingActionButton
    lateinit var lv_storage: ListView
    lateinit var posts: ArrayList<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage_home)
        posts = FileUtil.loadPosts(this)

        fab_add = this.findViewById(R.id.fab_add)
        fab_add.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, StorageAddActivity::class.java)
            startActivityIfNeeded(intent, 1);
        }

        lv_storage = this.findViewById<ListView>(R.id.lv_storage)
        lv_storage.adapter = PostAdapter(this, R.layout.post_item, posts)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            posts = FileUtil.loadPosts(this)
            lv_storage.adapter = PostAdapter(this, R.layout.post_item, posts)
        }
    }
}
