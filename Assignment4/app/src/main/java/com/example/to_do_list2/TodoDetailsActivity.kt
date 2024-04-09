package com.example.to_do_list2
/*
* Name: Naimil Shah
* Student id : 200522618
* File name: ToDoDetailsActivity
* Date:08-04-2024
*  Description : This file is there for any activity related to the todo details
* Version : V 2.0*/
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.to_do_list2.databinding.ActivityTodoDetailsBinding

class TodoDetailsActivity:AppCompatActivity() {
    private lateinit var binding: ActivityTodoDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Closing TodoDetailsActivity when "Cancel" button is clicked
        binding.cancelButton.setOnClickListener { finish() }
    }
}