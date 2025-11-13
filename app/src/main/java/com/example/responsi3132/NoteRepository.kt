package com.example.responsi3132

object NoteRepository {
    val notes: ArrayList<Note> = ArrayList()

    init {
        notes.add(Note("Contoh: Belajar Kotlin", "Pelajari dasar syntax, class, dan collection.", "Penting"))
        notes.add(Note("Belanja", "Telur, susu, beras", "Normal"))
    }
}
