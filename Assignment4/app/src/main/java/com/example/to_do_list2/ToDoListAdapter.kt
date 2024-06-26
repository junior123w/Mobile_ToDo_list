package com.example.to_do_list2
/*
* Name: Naimil Shah
* Student id : 200522618
* File name: Main activity
* Date:08-04-2024
*  Description : This file is there to manage the data that is organized in the todo list
* Version : V 2.0*/
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_list2.databinding.ActivityTodoListBinding
import java.text.SimpleDateFormat

class ToDoListAdapter(private val context: Context, private val items: MutableList<Tasks>) :
    RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityTodoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        // Bind data to views
        holder.binding.taskName.text = item.name
        holder.binding.dueDate.text = SimpleDateFormat("yyyy-MM-dd").format(item.dueDate.toDate())

        // Apply strikethrough if task is completed
        if (item.isCompleted) {
            holder.binding.taskName.applyStrikeThrough()
        } else {
            holder.binding.taskName.removeStrikeThrough()
        }

        // OnClickListener for editButton -> jump to ToDoDetailsActivity
        holder.binding.editButton.setOnClickListener {
            val intent = Intent(context, TodoDetailsActivity::class.java)
            context.startActivity(intent)
        }

        // LongClickListener to mark task as completed
        holder.itemView.setOnLongClickListener {
            item.isCompleted = true
            notifyDataSetChanged()
            true
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addTodo(todo: Tasks) {
        items.add(todo)
        notifyItemInserted(items.size - 1)
    }

    inner class ViewHolder(val binding: ActivityTodoListBinding) : RecyclerView.ViewHolder(binding.root)

    private fun TextView.applyStrikeThrough() {
        this.paintFlags = this.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
    }

    private fun TextView.removeStrikeThrough() {
        this.paintFlags = this.paintFlags and android.graphics.Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}
