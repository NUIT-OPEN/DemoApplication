package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListActivity : AppCompatActivity() {
    lateinit var lv_list: ListView
    lateinit var fruits: ArrayList<Fruit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initFruits();

        lv_list = findViewById(R.id.lv_list)
        lv_list.adapter = FruitAdapter(this, R.layout.fruit_item, fruits)
    }

    fun initFruits() {
        fruits = ArrayList()

        for (i in 1..10) {
            fruits.add(
                Fruit(
                    "🍎",
                    androidx.appcompat.R.drawable.abc_ic_menu_overflow_material,
                    10.23,
                    "Just a Apple."
                )
            )
            fruits.add(
                Fruit(
                    "🍍",
                    androidx.appcompat.R.drawable.abc_ic_menu_cut_mtrl_alpha,
                    20.47,
                    "Just a Pineapple."
                )
            )
            fruits.add(
                Fruit(
                    "🍌",
                    androidx.appcompat.R.drawable.abc_ic_clear_material,
                    10.24,
                    "Just a Banana."
                )
            )
            fruits.add(
                Fruit(
                    "🍊",
                    androidx.appcompat.R.drawable.abc_ic_voice_search_api_material,
                    20.48,
                    "Just a Orange."
                )
            )
        }
    }
}