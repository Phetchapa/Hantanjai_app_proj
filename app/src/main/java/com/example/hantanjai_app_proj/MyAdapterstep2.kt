package com.example.hantanjai_app_proj

import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapterstep2(
    private val friendNames: Array<String>,
    private val userProfiles: IntArray,
    private val editTextValues: MutableList<String?>
) : RecyclerView.Adapter<MyAdapterstep2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todo_taskedit, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTextView?.text = friendNames[position]
        holder.imageIdView?.setImageResource(userProfiles[position])

        holder.editText!!.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                editTextValues[position] = holder!!.editText!!.text.toString()
                true
            } else {
                false
            }
        }
    }

    override fun getItemCount(): Int {
        return friendNames.size
    }

    fun getEditTextValues(): List<String?> {
        return editTextValues
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var nameTextView: TextView? = itemView.findViewById(R.id.task_titlestep2)
        internal var imageIdView: CircleImageView? = itemView.findViewById(R.id.profile_imagestep2)
        internal var editText: EditText? = itemView.findViewById(R.id.task_editstep2)
    }
}
