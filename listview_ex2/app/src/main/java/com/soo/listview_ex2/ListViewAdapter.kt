package com.soo.listview_ex2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val list: MutableList<ListViewModel>):BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val convertView = view?:LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent, false)

        val title1 = convertView!!.findViewById<TextView>(R.id.listviewItemText1)
        val title2 = convertView!!.findViewById<TextView>(R.id.listviewItemText2)
        title1.text = list[position].text1
        title2.text = list[position].text2

        return convertView
    }
}