package com.example.chucklenorris.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucklenorris.ChuckleNorrisApplication
import com.example.chucklenorris.R
import com.example.chucklenorris.ui.adapters.JokesAdapter

class JokesFragment : Fragment() {

    private lateinit var jokesRecyclerView: RecyclerView

    private val jokesAdapter = JokesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        ChuckleNorrisApplication.component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
    }

    private fun initViews(view: View) {
        with(view) {
            jokesRecyclerView = findViewById(R.id.rv_jokes)
        }
        jokesRecyclerView.adapter = jokesAdapter

        val dividerItemDecoration = DividerItemDecoration(
            jokesRecyclerView.context,
            LinearLayoutManager.VERTICAL
        )
        jokesRecyclerView.addItemDecoration(dividerItemDecoration)
    }
}