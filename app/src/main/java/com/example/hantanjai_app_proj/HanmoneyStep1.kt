package com.example.hantanjai_app_proj

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.compose.ui.graphics.Color
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HanmoneyStep1 : AppCompatActivity() {

    private val myList = mutableListOf(
        TaskItem("Get a Haircut", "Keep Hair Short"),
        TaskItem("Go to The Park", "Take Tubby With You"),
        TaskItem("Buy Some Apples", "Make Sure They are Fresh"),
        TaskItem("Get a Haircut", "Keep Hair Short"),
        TaskItem("Go to The Park", "Take Tubby With You"),
        TaskItem("Buy Some Apples", "Make Sure They are Fresh"),
        TaskItem("Get a Haircut", "Keep Hair Short"),
        TaskItem("Go to The Park", "Take Tubby With You"),
        TaskItem("Buy Some Apples", "Make Sure They are Fresh"),
        TaskItem("Get a Haircut", "Keep Hair Short"),
        TaskItem("Go to The Park", "Take Tubby With You"),
        TaskItem("Buy Some Apples", "Make Sure They are Fresh"),
        TaskItem("Get a Haircut", "Keep Hair Short"),
        TaskItem("Go to The Park", "Take Tubby With You"),
        TaskItem("Buy Some Apples", "Make Sure They are Fresh"),
        TaskItem("Get a Haircut", "Keep Hair Short"),
        TaskItem("Go to The Park", "Take Tubby With You"),
        TaskItem("Buy Some Apples", "Make Sure They are Fresh"),
    )

    private var tracker: SelectionTracker<Long>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanmoney_step_one)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RVAdapter(myList)
        recyclerView.adapter = adapter

        tracker = SelectionTracker.Builder(
            "selection-1",
            recyclerView,
            StableIdKeyProvider(recyclerView),
            ItemLookup(recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        savedInstanceState?.let {
            tracker?.onRestoreInstanceState(it)
        }

        adapter.setTracker(tracker)

        tracker?.addObserver(
            object : SelectionTracker.SelectionObserver<Long>() {
                override fun onSelectionChanged() {
                    val nItems: Int? = tracker?.selection?.size()
                    nItems?.let {
                        if (it > 0) {
                            title = "$it items selected"
                            supportActionBar?.setBackgroundDrawable(
                                ColorDrawable(getColor(R.color.orange_700))
                            )
                        } else {
                            title = "RecyclerSelection"
                            supportActionBar?.setBackgroundDrawable(
                                ColorDrawable(getColor(R.color.purple_500))
                            )
                        }
                    }
                }
            })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        tracker?.onSaveInstanceState(outState)
    }

    data class TaskItem(val title: String, val description: String)

    class RVAdapter(private val listItems: List<TaskItem>) :
        RecyclerView.Adapter<RVAdapter.TaskViewHolder>() {

        class TaskViewHolder(todoTaskView: View) : RecyclerView.ViewHolder(todoTaskView) {
            val title: TextView = todoTaskView.findViewById(R.id.task_title)
            val description: TextView = todoTaskView.findViewById(R.id.task_detail)

            fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
                object : ItemDetailsLookup.ItemDetails<Long>() {
                    override fun getPosition(): Int = bindingAdapterPosition
                    override fun getSelectionKey(): Long = itemId
                }
        }

        init {
            setHasStableIds(true)
        }

        private var tracker: SelectionTracker<Long>? = null

        fun setTracker(tracker: SelectionTracker<Long>?) {
            this.tracker = tracker
        }

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getItemCount(): Int = listItems.size

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TaskViewHolder {
            val v: View =
                LayoutInflater.from(viewGroup.context).inflate(R.layout.todo_task, viewGroup, false)
            return TaskViewHolder(v)
        }

        override fun onBindViewHolder(taskViewHolder: TaskViewHolder, position: Int) {
            taskViewHolder.title.text = listItems[position].title
            taskViewHolder.description.text = listItems[position].description
            val parentCard = taskViewHolder.title.parent.parent as CardView
            parentCard.isClickable = true // Add this line to make the CardView clickable
            parentCard.setOnClickListener {
                tracker?.select(position.toLong())
            }
            tracker?.let {
                if (it.isSelected(position.toLong())) {
                    parentCard.background = ColorDrawable(android.graphics.Color.LTGRAY)
                } else {
                    parentCard.background = ColorDrawable(android.graphics.Color.WHITE)
                }
            }
        }


    }

    class ItemLookup(private val rv: RecyclerView) : ItemDetailsLookup<Long>() {
        override fun getItemDetails(event: MotionEvent)
                : ItemDetails<Long>? {
            val view = rv.findChildViewUnder(event.x, event.y)
            if (view != null) {
                return (rv.getChildViewHolder(view) as RVAdapter.TaskViewHolder)
                    .getItemDetails()
            }
            return null
        }
    }
}
