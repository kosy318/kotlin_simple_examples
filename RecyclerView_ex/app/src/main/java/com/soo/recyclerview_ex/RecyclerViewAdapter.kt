package com.soo.recyclerview_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val items: MutableList<String>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    // recyclerview의 item을 불러옴
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)

        return ViewHolder(view)
    }

    // Adapter에 직접 선언을 해줘야 사용할 수 있다.
    interface ItemClick{
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null

    // 불러온 item을 view binding
    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {

        // 클릭했을 때
        if(itemClick != null){
            holder.itemView.setOnClickListener{
                itemClick?.onClick(it, position)
            }
        }
        holder.bindItems(items[position])
    }

    // 전체 리사이클러뷰의 개수
    override fun getItemCount(): Int {
        return items.size
    }


    // ViewHolder로 view를 재사용해서 성능이 ListView에 비해 좋다.
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItems(item: String){
            val recyclerviewText = itemView.findViewById<TextView>(R.id.recyclerViewItem)
            recyclerviewText.text = item
        }
    }
}