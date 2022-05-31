package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class PostAdapter(
    context: Context,
    val resource: Int,
    objects: MutableList<Post>
) : ArrayAdapter<Post>(context, resource, objects) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(resource, parent, false)
        val post = getItem(position)
        if (post != null) {
            view.findViewById<TextView>(R.id.tv_title).setText(post.title)
            view.findViewById<TextView>(R.id.tv_description).setText(post.description)
        }

        return view
    }
}