package com.example.responsi3132

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.rvNotes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = NoteAdapter(NoteRepository.notes) { note ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra(Note.EXTRA_TITLE, note.title)
            intent.putExtra(Note.EXTRA_CONTENT, note.content)
            intent.putExtra(Note.EXTRA_PRIORITY, note.priority)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        val fab: FloatingActionButton = view.findViewById(R.id.fabAdd)
        fab.setOnClickListener {
            val intent = Intent(requireContext(), AddNoteActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
