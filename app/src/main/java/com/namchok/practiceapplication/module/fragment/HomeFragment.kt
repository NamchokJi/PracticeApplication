package com.namchok.practiceapplication.module.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.namchok.practiceapplication.R
import com.namchok.practiceapplication.module.adapter.NewsAdapter
import com.namchok.practiceapplication.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject


class HomeFragment : Fragment() {

    private var mAdapter = NewsAdapter()
    private val viewModel: AppViewModel by inject()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerNews.layoutManager = layoutManager
        recyclerNews.adapter = mAdapter
        viewModel?.getListArtist()
        viewModel?.apply {
            mListNews?.observe(this@HomeFragment, Observer {
                mAdapter.setListNews(it)
                mAdapter?.notifyDataSetChanged()
            })
        }
    }

}