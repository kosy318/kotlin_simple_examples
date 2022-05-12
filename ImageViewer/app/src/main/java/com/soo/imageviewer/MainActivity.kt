package com.soo.imageviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.soo.imageviewer.databinding.ActivityImageInsideBinding
import com.soo.imageviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // data binding을 사용해보자
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        // 1. 화면이 클릭되었다는 것을 알아야함
//        val image1 = findViewById<ImageView>(R.id.image_1)
//        image1.setOnClickListener {
//            Toast.makeText(this, "1번 클릭 완료", Toast.LENGTH_LONG).show()
//
//            // 2. 화면이 클릭되면, 다음 화면으로 넘어가서, 사진을 크게 보여줌
//            var intent = Intent(this, Image1Activity::class.java)
//            startActivity(intent)
//        }

        // data binding 덕분에 필요 없다.
//        val btn1 = findViewById<ImageView>(R.id.image_1)
//        val btn2 = findViewById<ImageView>(R.id.image_2)
//        val btn3 = findViewById<ImageView>(R.id.image_3)
//        val btn4 = findViewById<ImageView>(R.id.image_4)
//        val btn5 = findViewById<ImageView>(R.id.image_5)
//        val btn6 = findViewById<ImageView>(R.id.image_6)
//        val btn7 = findViewById<ImageView>(R.id.image_7)


        binding.image1.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)

            // 값 보내기
            intent.putExtra("data", "1")
            startActivity(intent)
        }
        binding.image2.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)

            intent.putExtra("data", "2")
            startActivity(intent)
        }
        binding.image3.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)

            intent.putExtra("data", "3")
            startActivity(intent)
        }
        binding.image4.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)

            intent.putExtra("data", "4")
            startActivity(intent)
        }
        binding.image5.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)

            intent.putExtra("data", "5")
            startActivity(intent)
        }
        binding.image6.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)

            intent.putExtra("data", "6")
            startActivity(intent)
        }
        binding.image7.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)

            intent.putExtra("data", "7")
            startActivity(intent)
        }
    }
}