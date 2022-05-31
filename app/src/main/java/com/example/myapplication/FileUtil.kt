package com.example.myapplication

import android.content.Context
import java.io.File

class FileUtil {
    companion object {
        fun getFile(context: Context): File {
            val file = File(String.format("%s/file.txt", context.filesDir.path))
            if (!file.exists())
                file.createNewFile()
            return file
        }

        fun loadPosts(context: Context): ArrayList<Post> {
            val posts = ArrayList<Post>()
            val data_str = getFile(context).readText()

            val items_strs = data_str.split("\n\n")
            for (item_strs in items_strs) {
                val item_str = item_strs.split("\t\t")
                if (item_str.size == 2)
                    posts.add(
                        Post(
                            item_str[0],
                            item_str[1],
                        )
                    )
            }

            return posts
        }

        fun savePosts(context: Context, posts: ArrayList<Post>) {
            val data_sb = StringBuilder()
            for (post in posts) {
                data_sb.append(String.format("%s\t\t%s", post.title, post.description))
                data_sb.append("\n\n")
            }

            getFile(context).writeText(
                data_sb.toString()
            )
        }
    }
}