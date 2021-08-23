package com.tripmate.navigation_keepstate_poc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private var adapter : Adapter? = null
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val arrayList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)

        Log.d("MainActivity" , "Fragment1 onCreateView ")

        dataSet(100)

        return view
    }

    fun dataSet(n : Int){
        Log.d("MainActivity" , "Fragment1 dataSet ")
        var a = 0

        for(i in 0..n step 1){
            ++a
            arrayList.add(a.toString())
        }

        adapter = Adapter(arrayList)
        linearLayoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = linearLayoutManager
        adapter!!.notifyDataSetChanged()

    }

}