package com.example.to_do_list
/*
* Name: Naimil Shah
* Student id : 200522618
* File name: Main activity
* Date:24-03-2024
*  Description : This is a task tracker app that will keep of task that you can create edit and delete
* Version : V 1.0*/

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.to_do_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use 'this' directly to start the new activity
        binding.addTaskFAB.setOnClickListener{
            val intent = Intent(this, TodoDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}
