package com.blogspot.devofandroid.bayrakuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val dogrusayac = intent.getIntExtra("dogrusayac",0)
        textViewSonuc.text="$dogrusayac DOĞRU ${5-dogrusayac} YANLIŞ"
        textViewYuzdeSonuc.text ="% ${(dogrusayac+100)/5} başarı "
        buttontekrar.setOnClickListener {
            startActivity(Intent(this@ResultActivity,QuizActivity::class.java))
            finish()
        }
    }
}