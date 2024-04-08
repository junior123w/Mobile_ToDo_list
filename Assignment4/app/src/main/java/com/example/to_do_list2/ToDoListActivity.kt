package com.example.to_do_list2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_do_list2.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp

class   ToDoListActivity : AppCompatActivity() {

    private lateinit var todoAdapter: ToDoAdapter
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
            val recyclerView = binding.RecyclerView
            recyclerView.layoutManager = LinearLayoutManager(this)
            todoAdapter = ToDoAdapter(this, tasks)
            recyclerView.adapter = todoAdapter
        }
    }}

