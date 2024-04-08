package com.example.to_do_list2

import java.sql.Timestamp

data class Tasks(
    val name: String = "",
    val isCompleted: Boolean = false,
    val notes: String = "",
    val hasDueDate: Boolean = true,
    val dueDate:String =""
)
