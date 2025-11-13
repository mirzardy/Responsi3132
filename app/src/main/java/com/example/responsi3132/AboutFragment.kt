package com.example.responsi3132

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val tvAbout: TextView = view.findViewById(R.id.tvAbout)
        val name = getString(R.string.name_student)
        val nim = getString(R.string.nim_student)
        tvAbout.text = "$name\nNIM: $nim"

        return view
    }
}
