package com.example.responsi3132

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var tvContent: TextView
    private lateinit var tvPriority: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvTitle = findViewById(R.id.tvDetailTitle)
        tvContent = findViewById(R.id.tvDetailContent)
        tvPriority = findViewById(R.id.tvDetailPriority)

        val title = intent.getStringExtra(Note.EXTRA_TITLE) ?: "-"
        val content = intent.getStringExtra(Note.EXTRA_CONTENT) ?: "-"
        val priority = intent.getStringExtra(Note.EXTRA_PRIORITY) ?: "-"

        tvTitle.text = title
        tvContent.text = content
        tvPriority.text = priority
    }
}
