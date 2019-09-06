package com.example.android_sprint_networking_challenge.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_sprint_networking_challenge.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image_view_search.setOnClickListener {
            val value: String = edit_text.text.toString()
            val intent = Intent(this,DetailsActivity::class.java)
            intent.putExtra("value", value)
            startActivity(intent)
        }
    }
}
