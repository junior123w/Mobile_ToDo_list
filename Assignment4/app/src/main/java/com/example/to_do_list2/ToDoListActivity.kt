package com.example.to_do_list2

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_do_list2.databinding.ActivityMainBinding
import com.example.to_do_list2.databinding.DialogNewTodoBinding
import com.google.firebase.FirebaseApp

class   ToDoListActivity : AppCompatActivity() {

    private lateinit var todolistAdapter: ToDoListAdapter
    private val todoList: MutableList<Tasks> = mutableListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize FireBase:
        FirebaseApp.initializeApp(this)

        val firestore = FirebaseDataManager()
        firestore.getTasks { tasks ->
            todoList.clear()
            todoList.addAll(tasks)
            val recyclerView = binding.RecyclerView
            recyclerView.layoutManager = LinearLayoutManager(this)
            todolistAdapter = ToDoListAdapter(this,todoList)
            recyclerView.adapter = todolistAdapter
        }
        binding.addTaskFAB.setOnClickListener {
            showNewTodoDialog()
        }
    }

    private fun showNewTodoDialog() {
        // Create and show a dialog to allow the user to enter a new todo
        val dialogBinding = DialogNewTodoBinding.inflate(LayoutInflater.from(this))
        val dialog = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .create()

        // Set up the dialog
        val nameEditText = dialogBinding.nameEditText
        val saveButton = dialogBinding.saveButton
        val cancelButton = dialogBinding.cancelButton

        saveButton.setOnClickListener {
            val newTodoName = nameEditText.text.toString()
            if (newTodoName.isNotEmpty()) {
                // Create a new Tasks object and add it to the database
                val newTodo = Tasks(name = newTodoName)
                val firestore =FirebaseDataManager()
                // Call a method in FirebaseDataManager to save the new todo
                firestore.saveTodo(newTodo) { success,error ->
                    if (success) {
                        todoList.add(newTodo)

                        this.todolistAdapter.notifyItemInserted(todoList.size - 1)

                    } else {
                        // Handle the error
                        handleSaveError(error)
                    }
                }
                dialog.dismiss()
            }
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }

    private fun handleSaveError(error:Exception?) {
        Toast.makeText(this, "Error saving todo: $error", Toast.LENGTH_SHORT).show()
    }

}
