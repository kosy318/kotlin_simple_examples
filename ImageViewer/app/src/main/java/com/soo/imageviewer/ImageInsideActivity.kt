package com.soo.imageviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.soo.imageviewer.databinding.ActivityImageInsideBinding

class ImageInsideActivity : AppCompatActivity() {
    // data binding을 사용해보자
    private lateinit var binding: ActivityImageInsideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_inside)

        // 값 가져오기
        val getData = intent.getStringExtra(("data"))
        Toast.makeText(this, getData+"번 사진 클릭", Toast.LENGTH_SHORT).show()

        // data binding 덕분에 필요 없다.
        // val ImageArea = findViewById<ImageView>(R.id.ImageArea)

        // ImageArea.setImageResource(R.drawable.seoguri_1)
        // 비효율적인것같아서 검색했음, 검색 내용 : setimageresource kotlin with variable
        binding.ImageArea.setImageResource(resources.getIdentifier("seoguri_"+getData, "drawable", getPackageName()))

        // 다시 클릭하면 종료
        binding.ImageArea.setOnClickListener {
            finish()
        }
    }
}