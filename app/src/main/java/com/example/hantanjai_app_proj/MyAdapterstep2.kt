package com.example.hantanjai_app_proj

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapterstep2(val items:Array<String>, val imageId:Array<Int>):
    RecyclerView.Adapter<MyAdapterstep2.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterstep2.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.todo_taskedit, parent, false))
    }
    override fun onBindViewHolder(holder: MyAdapterstep2.ViewHolder, position: Int)
    {
        holder.nameTextView?.text = items.get(position)
        holder.imageIdView?.setImageResource(imageId.get(position))
    }
    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var nameTextView : TextView? = itemView.findViewById(R.id.task_titlestep2)
        internal var imageIdView : CircleImageView? = itemView.findViewById(R.id.profile_imagestep2)
    }
}