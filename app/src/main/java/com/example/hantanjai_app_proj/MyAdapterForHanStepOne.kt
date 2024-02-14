package com.example.hantanjai_app_proj

import android.annotation.SuppressLint
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapterForHanStepOne(val items:Array<String>, val imageId:Array<Int>):
    RecyclerView.Adapter<MyAdapterForHanStepOne.ViewHolder>(){

    private var selectedItems = mutableListOf<Int>()

    //send
    // Function to get selected indices
    fun getSelectedIndices(): List<Int> {
        return selectedItems.toList()
    }
    //end send

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterForHanStepOne.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todo_task, parent, false))
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val isSelected = selectedItems.contains(position)

        holder.nameTextView?.text = items[position]
        holder.imageIdView?.setImageResource(imageId[position])


        // Change background color based on selection
        val backgroundColor = if (isSelected) R.color.ColorLightGray else R.color.white
        holder.cardView?.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, backgroundColor))

        // Set the click listener for item selection
        holder.itemView.setOnClickListener {
            if (isSelected) {
                selectedItems.remove(position)
            } else {
                selectedItems.add(position)
            }
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // Function to get selected items
    fun getSelectedItems(): List<Pair<String, Int>> {
        return selectedItems.map { position ->
            Pair(items[position], imageId[position])
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var nameTextView : TextView? = itemView.findViewById(R.id.task_title)
        internal var imageIdView : CircleImageView? = itemView.findViewById(R.id.profile_image)
        internal var cardView: CardView? = itemView.findViewById(R.id.card_view)
    }
}