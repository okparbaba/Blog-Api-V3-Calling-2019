package com.softwarefactorymm.bloggerapitest

import android.content.Context
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class PostAdapter(var context: Context,var list: List<Item>):RecyclerView.Adapter<PostAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val t = list[position].content
        val o = Html.fromHtml(list[position].content).toString()
        Log.e("adapter",o)
        val p = o.replace("￼","")
        holder.t.text =p
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        var t = view.textView
    }
}
