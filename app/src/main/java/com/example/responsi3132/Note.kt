package com.example.responsi3132

data class Note(
    val title: String,
    val content: String,
    val priority: String
) {
    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_CONTENT = "extra_content"
        const val EXTRA_PRIORITY = "extra_priority"
    }
}
