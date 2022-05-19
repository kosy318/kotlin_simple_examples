package com.soo.listview_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_item = mutableListOf<ListViewModel>(ListViewModel("A", "a"),
                                                    ListViewModel("B", "b"),
                                                    ListViewModel("C", "c"))

        val listview = findViewById<ListView>(R.id.mainListView)

        val listviewAdapter = ListViewAdapter(list_item)
        listview.adapter = listviewAdapter

        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, list_item[position].text1+" "+list_item[position].text2, Toast.LENGTH_SHORT).show()
        }
    }
}