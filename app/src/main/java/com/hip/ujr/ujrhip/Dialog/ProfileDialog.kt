package com.hip.ujr.ujrhip.Dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.hip.ujr.ujrhip.R

@Suppress("UNREACHABLE_CODE")
class ProfileDialog(context: Context, private val menuName: ArrayList<String>) : BaseAdapter() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int { return menuName.size }
    override fun getItem(position: Int): Any { return position }

    override fun getItemId(position: Int): Long { return position.toLong() }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        var view: View? = convertView

        if (view == null) {
            view = layoutInflater.inflate(R.layout.dialog_profile, parent, false)

            viewHolder = ViewHolder(view!!.findViewById(R.id.text_view), view.findViewById(R.id.view_divider))

            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.textView.text = menuName[position]
        if(position == 0)
            viewHolder.view.visibility = View.VISIBLE
        else
            viewHolder.view.visibility = View.GONE

        return view
    }

    data class ViewHolder(val textView: TextView,val view : View)
}