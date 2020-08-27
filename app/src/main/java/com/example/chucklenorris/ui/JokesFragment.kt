package com.example.chucklenorris.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucklenorris.ChuckleNorrisApplication
import com.example.chucklenorris.R
import com.example.chucklenorris.ui.adapters.JokesAdapter
import com.example.chucklenorris.ui.viewmodel.SharedViewModel
import com.example.chucklenorris.ui.viewmodel.SharedViewModelFactory
import javax.inject.Inject

class JokesFragment : Fragment() {

    @Inject
    lateinit var sharedViewModelFactory: SharedViewModelFactory

    private val sharedViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            sharedViewModelFactory
        ).get(SharedViewModel::class.java)
    }

    private val reloadButton by lazy { requireView().findViewById<Button>(R.id.btn_get_jokes) }
    private val numberOfJokesEditText by lazy { requireView().findViewById<EditText>(R.id.et_number_of_jokes) }

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
        initLiveData()
    }

    private fun initViews(view: View) {
        reloadButton.setOnClickListener {
            sharedViewModel.getJokes(numberOfJokesEditText.text.toString().toInt())
        }

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

    private fun initLiveData() {
        sharedViewModel.currentJokes.observe(viewLifecycleOwner, Observer {
            jokesAdapter.setItems(it)
        })
    }
}