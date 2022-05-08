package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(
    context: Context,
    val resource: Int,
    objects: MutableList<Fruit>
) : ArrayAdapter<Fruit>(context, resource, objects) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(resource, parent, false)
        val fruit = getItem(position)
        if (fruit != null) {
            view.findViewById<ImageView>(R.id.iv_img).setImageResource(fruit.image)
            view.findViewById<TextView>(R.id.tv_name).setText(fruit.name)
            view.findViewById<TextView>(R.id.tv_price).setText(String.format("¥ %s", fruit.price.toString()))
            view.findViewById<TextView>(R.id.tv_description).setText(fruit.description)
        }

        return view
    }
}