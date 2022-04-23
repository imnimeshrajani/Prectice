package com.example.prectice.RV_IN_KOTLIN

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prectice.R

class MyAdapter(val mainActivity: MainActivity, val list: ArrayList<ModelClass>) :
    RecyclerView.Adapter<MyAdapter.ViewData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(mainActivity).inflate(R.layout.item, parent, false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.t1.text=list[position].list1
        holder.t2.text=list[position].list2
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val t1=itemView.findViewById<TextView>(R.id.t1)
        val t2=itemView.findViewById<TextView>(R.id.t2)
    }
}