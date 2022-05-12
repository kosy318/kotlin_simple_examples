package com.soo.sentencelists

import android.content.Intent
import android.hardware.SensorEvent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.soo.sentencelists.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sentenceList = mutableListOf<String>()
        sentenceList.add("코틀린 재밌다")
        sentenceList.add("c++ 재밌다")
        sentenceList.add("파이썬 재밌다")
        sentenceList.add("웹개발 재밌다")
        sentenceList.add("앱개발 재밌다")
        sentenceList.add("데이터분석 재밌다")
        sentenceList.add("물리 재밌다")
        sentenceList.add("수학 재밌다")
        sentenceList.add("다 재밌다")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.showAll.setOnClickListener {
            val intent = Intent(this, SentenceActivity::class.java)
            intent.putExtra("sentences", ArrayList(sentenceList))
            startActivity(intent)
        }

        var randomSentence = sentenceList.random() // .random()하면 랜덤하게 나온다!!
        binding.sentenceArea.setText(randomSentence)

        binding.refreshBtn.setOnClickListener{
            randomSentence = sentenceList.random()
            binding.sentenceArea.setText(randomSentence)
        }
        Log.d("MainActivity", randomSentence)
    }
}