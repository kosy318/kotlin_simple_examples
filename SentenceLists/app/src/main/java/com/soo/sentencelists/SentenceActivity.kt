package com.soo.sentencelists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class SentenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)

        var sentenceList: MutableList<String>? = (intent.getStringArrayListExtra("sentences"))?.toMutableList()

        val sentenceAdapter = sentenceList?.let { ListViewAdapter(it) }
        val listView = findViewById<ListView>(R.id.sentenceListView)

        listView.adapter = sentenceAdapter
    }
}