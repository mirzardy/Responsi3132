package com.example.responsi3132

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddNoteActivity : AppCompatActivity() {

    private lateinit var etTitle: EditText
    private lateinit var etContent: EditText
    private lateinit var rgPriority: RadioGroup
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        etTitle = findViewById(R.id.etTitle)
        etContent = findViewById(R.id.etContent)
        rgPriority = findViewById(R.id.rgPriority)
        btnSave = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val content = etContent.text.toString().trim()

            val selectedId = rgPriority.checkedRadioButtonId
            val priority = when (selectedId) {
                R.id.rbHigh -> getString(R.string.priority_high)
                R.id.rbNormal -> getString(R.string.priority_normal)
                R.id.rbLow -> getString(R.string.priority_low)
                else -> getString(R.string.priority_normal)
            }

            if (title.isEmpty()) {
                Toast.makeText(this, getString(R.string.err_title_required), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val note = Note(title, content, priority)
            NoteRepository.notes.add(note)

            Toast.makeText(this, getString(R.string.msg_note_saved), Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
