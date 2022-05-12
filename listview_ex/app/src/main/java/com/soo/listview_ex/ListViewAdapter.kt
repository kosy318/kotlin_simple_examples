package com.soo.listview_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text

// MutableList type인 List라는 변수를 받을거임
// class ListViewAdapter(val List : MutableList<String>) : BaseAdapter(){ // List에 값이 들어옴
class ListViewAdapter(val List : MutableList<ListViewModel>) : BaseAdapter(){ // List에 MutableList<ListViewModel> 값이 들어옴
    // listview의 개수
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
        var conView = convertView
        if(conView == null){  // 아이템을 가져옴
            conView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent,false)
        }

        val title = conView!!.findViewById<TextView>(R.id.listviewItem)
        // titile의 text를 List에 있는 item들로 연결해라.
        // title.text = List[position]

        // ListViewModel 타입용
        val content = conView!!.findViewById<TextView>(R.id.listviewItem2)
        title.text = List[position].title
        content.text = List[position].content

        return conView!!
    }
}