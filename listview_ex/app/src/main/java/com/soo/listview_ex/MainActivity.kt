package com.soo.listview_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // 뒤로가기가 두번 눌러졌는지 확인하는 변수
    private var isDouble = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // list 만들어줌
//        val list_item = mutableListOf<String>()
//
//        list_item.add("A")
//        list_item.add("B")
//        list_item.add("C")
//
//        // mainListview에있는 adapter에 listAdapter를 연결해주겠다
//        val mainListview = findViewById<ListView>(R.id.mainListview)
//        val listAdapter = ListViewAdapter(list_item) // ListViewAdpater에는 list_item을 넣어줌
//
//        mainListview.adapter = listAdapter


        // ListViewModel용
        // ListViewModel 타입을 ListViewAdapter에서 받으려면 수정을 해줘야함
        val list_model_item = mutableListOf<ListViewModel>()

        list_model_item.add(ListViewModel("a", "b"))
        list_model_item.add(ListViewModel("c", "d"))
        list_model_item.add(ListViewModel("e", "f"))

        val mainListview = findViewById<ListView>(R.id.mainListview)
        val listAdapter = ListViewAdapter(list_model_item) // ListViewAdpater에는 list_model_item을 넣어줌

        mainListview.adapter = listAdapter

        // header를 추가해봤다!!!!!!!!!!
        val header = layoutInflater.inflate(R.layout.header, null, false)

        mainListview.addHeaderView(header)

    }


    // 뒤로가기가 발생하면,
    override fun onBackPressed() {
        Log.d("MainActivity", "baackbutton")
        if(isDouble == true) finish()

        // isDouble이 아직 true가 아니면 여기로 넘어와서 isDouble을 true로 바꾼다.
        isDouble = true
        Toast.makeText(this, "버튼을 한번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show()

        // 2초가 지나면 isDouble을 false로 바꿔준다.
        Handler(Looper.getMainLooper()).postDelayed({
            isDouble = false
        }, 2000)
    }
}