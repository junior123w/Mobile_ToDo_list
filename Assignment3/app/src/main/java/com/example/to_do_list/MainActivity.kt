package com.example.to_do_list
/*
* Name: Naimil Shah
* Student id : 200522618
* File name: Main activity
* Date:24-03-2024
*  Description : This is a task tracker app that will keep of task that you can create edit and delete
* Version : V 1.0*/

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_do_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var context :Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this // Initializing context with the current activity's context

        //added  intent for FAB so that it can access the other xml file
        binding.addTaskFAB.setOnClickListener{
            val intent = Intent(context, TodoDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

}