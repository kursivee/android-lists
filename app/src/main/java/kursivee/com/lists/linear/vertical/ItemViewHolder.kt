package kursivee.com.lists.linear.vertical

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_item.view.*

class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val id: TextView = view.item_number
    val content: TextView = view.content
}