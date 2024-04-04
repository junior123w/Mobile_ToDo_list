package com.example.to_do_list
/*
* Name: Naimil Shah
* Student id : 200522618
* File name: ToDoDetailsActivity
* Date:24-03-2024
*  Description : This is a task tracker app that will keep of task that you can create edit and delete
* Version : V 1.0*/
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.to_do_list.databinding.ActivityTodoDetailsBinding
//created a mock file so that I can see the other xml file
class TodoDetailsActivity:AppCompatActivity() {
    private lateinit var binding: ActivityTodoDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTodoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Closing TodoDetailsActivity when "Cancel" button is clicked
       // binding.cancelButton.setOnClickListener { finish() }
    }
}