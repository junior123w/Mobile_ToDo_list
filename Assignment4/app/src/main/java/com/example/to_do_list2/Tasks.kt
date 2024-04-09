package com.example.to_do_list2
/*
* Name: Naimil Shah
* Student id : 200522618
* File name: Tasks Data class
* Date:08-04-2024
*  Description : This is a dataclass that mimicks the firebase
* Version : V 2.0*/
import com.google.firebase.Timestamp
data class Tasks(
    val name: String = "",
    var isCompleted: Boolean = false,
    val notes: String = "",
    val hasDueDate: Boolean = true,
    val dueDate: Timestamp = Timestamp.now()
)
