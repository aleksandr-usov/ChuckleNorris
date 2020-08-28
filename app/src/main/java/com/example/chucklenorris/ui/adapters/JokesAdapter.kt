package com.example.chucklenorris.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.chucklenorris.R
import com.example.chucklenorris.data.api.model.Joke
import kotlinx.android.synthetic.main.joke_element.view.*
import java.lang.ref.WeakReference

class JokesAdapter : RecyclerView.Adapter<JokesAdapter.JokeViewHolder>() {

    private val jokes = mutableListOf<Joke>()

    fun setItems(newItems: List<Joke>) {
        jokes.clear()
        jokes.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JokeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.joke_element, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val item = jokes[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    inner class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var item: WeakReference<Joke>
        private val textViewJoke = itemView.tv_joke

        fun bind(item: Joke) {
            this.item = WeakReference(item)

            textViewJoke.text = HtmlCompat.fromHtml(item.joke, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
    }
}