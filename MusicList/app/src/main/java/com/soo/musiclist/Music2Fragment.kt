package com.soo.musiclist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Music2Fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_music2, container, false)

        view.findViewById<ImageView>(R.id.play1).setOnClickListener {
            it.findNavController().navigate(R.id.action_music2Fragment_to_music1Fragment)
        }
        view.findViewById<ImageView>(R.id.play3).setOnClickListener {
            it.findNavController().navigate(R.id.action_music2Fragment_to_music3Fragment)
        }

        val items = mutableListOf<String>()
        items.add("노래2-1")
        items.add("노래2-2")
        items.add("노래2-3")

        // fragment_music1.xml에서 MusicRv를 찾아옴옴
        val rv = view.findViewById<RecyclerView>(R.id.MusicRv)
        val rvAdapter = RecyclerViewAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        return view
    }
}