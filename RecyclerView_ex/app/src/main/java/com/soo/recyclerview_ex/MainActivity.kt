package com.soo.recyclerview_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<String>("a", "b", "c", "a", "b", "c", "a", "b", "c", "a", "b", "c", "a", "b", "c")

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)

        val recyclerViewAdapter = RecyclerViewAdapter(items)

        recyclerview.adapter = recyclerViewAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        // recyclerViewAdapter에 선언한 itemClick을 통해 사용
        recyclerViewAdapter.itemClick = object: RecyclerViewAdapter.ItemClick{
            override fun onClick(view: View, position: Int){
                Toast.makeText(baseContext, items[position], Toast.LENGTH_SHORT).show()
            }
        }
    }
}