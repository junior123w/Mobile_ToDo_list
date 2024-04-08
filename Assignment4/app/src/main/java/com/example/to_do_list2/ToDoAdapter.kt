package com.example.to_do_list2

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_list2.databinding.ActivityTodoListBinding
import java.text.SimpleDateFormat

class ToDoAdapter(private val context: Context, private val items: List<Tasks>) :
    RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

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

        // OnClickListener for editButton -> jump to ToDoDetailsActivity
        holder.binding.editButton.setOnClickListener {
            val intent = Intent(context, TodoDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addTodo(todo: Tasks) {
        notifyItemInserted(items.size - 1)
    }


    inner class ViewHolder(val binding: ActivityTodoListBinding) : RecyclerView.ViewHolder(binding.root)
}