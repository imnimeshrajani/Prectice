package com.example.prectice.SQLITE_IN_KOTLIN

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prectice.R

class DB_Adapter(val activity: SQL_Database_Activity, var list: ArrayList<DBModel>) : RecyclerView.Adapter<DB_Adapter.ViewData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view=LayoutInflater.from(activity).inflate(R.layout.item,parent,false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.txt1.text=list[position].name
        holder.txt2.text=list[position].mobile
        var dbHelper= DBHelper(activity)

        holder.linear.setOnClickListener{
            dbHelper.DELETE_DATA(list[position].id)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txt1=itemView.findViewById<TextView>(R.id.t1)
        var txt2=itemView.findViewById<TextView>(R.id.t2)
        var linear=itemView.findViewById<LinearLayout>(R.id.linear)
    }
}
