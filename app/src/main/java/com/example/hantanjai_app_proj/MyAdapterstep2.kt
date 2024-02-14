//package com.example.hantanjai_app_proj
//
//import android.view.KeyEvent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.EditText
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import de.hdodenhof.circleimageview.CircleImageView
//
//class MyAdapterstep2(
//    private val friendNames: Array<String>,
//    private val userProfiles: IntArray,
//    private val editTextValues: MutableList<String?>
//) : RecyclerView.Adapter<MyAdapterstep2.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.todo_taskedit, parent, false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.nameTextView?.text = friendNames[position]
//        holder.imageIdView?.setImageResource(userProfiles[position])
//
//        holder.editText!!.setOnKeyListener { _, keyCode, _ ->
//            if (keyCode == KeyEvent.KEYCODE_ENTER) {
//                editTextValues[position] = holder!!.editText!!.text.toString()
//                true
//            } else {
//                false
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return friendNames.size
//    }
//
//    fun getEditTextValues(): List<String?> {
//        return editTextValues
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        internal var nameTextView: TextView? = itemView.findViewById(R.id.task_titlestep2)
//        internal var imageIdView: CircleImageView? = itemView.findViewById(R.id.profile_imagestep2)
//        internal var editText: EditText? = itemView.findViewById(R.id.task_editstep2)
//    }
//}

package com.example.hantanjai_app_proj

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapterstep2(
    private val items: List<String>,
    private val imageId: List<Int>,
    private val editTextValues: MutableList<String?>,
    private val listener: (List<String?>) -> Unit
) : RecyclerView.Adapter<MyAdapterstep2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterstep2.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todo_taskedit, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTextView?.text = items[position]
        holder.imageIdView?.setImageResource(imageId[position])

        holder.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("YourTag", "onTextChanged: $charSequence")
                val adapterPosition = holder.adapterPosition

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    while (adapterPosition >= editTextValues.size) {
                        editTextValues.add(null) // Add null values to the list until the desired position is reached
                    }
                    editTextValues[adapterPosition] = charSequence?.toString() ?: ""
                    listener.invoke(editTextValues.filterNotNull())
                }
            }

            override fun afterTextChanged(editable: Editable?) {}
        })


    }
    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        internal var nameTextView : TextView? = itemView.findViewById(R.id.task_titlestep2)
        internal var imageIdView : CircleImageView? = itemView.findViewById(R.id.profile_imagestep2)
        internal var editText: EditText? = itemView.findViewById(R.id.task_editstep2)

    }
}