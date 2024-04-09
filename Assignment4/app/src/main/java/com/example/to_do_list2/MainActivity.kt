package com.example.to_do_list2
/*
* Name: Naimil Shah
* Student id : 200522618
* File name: Main activity
* Date:08-04-2024
*  Description : This is a task tracker app that will keep of task that you can create was
* not able to get the details only that name and due date can be seen and task can be strikethroughed
* if completed can be done
* Version : V 2.0*/

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.to_do_list2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var context :Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}