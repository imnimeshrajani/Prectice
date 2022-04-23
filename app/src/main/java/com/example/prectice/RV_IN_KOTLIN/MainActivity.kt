package com.example.prectice.RV_IN_KOTLIN

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prectice.R

class MainActivity : AppCompatActivity() {
    val rv:RecyclerView get()=findViewById(R.id.rv)
    var list1= arrayOf("ABC","BCD","CDE","DEF","EFG","FGH","GHI","HIJ","JKL","LMN");
    var list2= arrayOf("abc","bcd","cde","def","efg","fgh","ghi","hij","jkl","lmn");
    var list= arrayListOf<ModelClass>()
    var i=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        while (i<list1.size){
            var model= ModelClass(list1[i] ,list2[i])
            list.add(model)
            i++
        }
        var myadapter= MyAdapter(this,list)
        var layoutManager=LinearLayoutManager(this)
        rv.layoutManager=layoutManager
        rv.adapter=myadapter
    }
}