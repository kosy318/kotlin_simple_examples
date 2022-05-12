package com.soo.sentencelists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List: MutableList<String>): BaseAdapter() {
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // convertView가 null이면 뒤에거 들어감
        var convertView = convertView?:LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent, false)

        // convertView가 null이 아니면 뒤에거 수행
        val listviewText = convertView?.findViewById<TextView>(R.id.ItemArea)
        listviewText!!.text = List[position]

        return convertView!!
    }
}