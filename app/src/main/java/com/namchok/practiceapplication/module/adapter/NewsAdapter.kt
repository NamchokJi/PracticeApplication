package com.namchok.practiceapplication.module.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.namchok.practiceapplication.R
import com.namchok.practiceapplication.model.common.Article
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var mListArtist = ArrayList<Article>()
    var context:Context? = null

    fun setListNews(mList:ArrayList<Article>){
        this.mListArtist = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        context = parent.context
        return NewsAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return mListArtist.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.tvNameArtist
        var image = itemView.imgProfileArtist
        var author = itemView.tvArtistPopularity

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = mListArtist[position].title
        holder.author.text = mListArtist[position].author
        context?.let {
            Glide.with(it)
                .load(mListArtist[position].urlToImage)
                .into(holder.image)
        }

    }
}