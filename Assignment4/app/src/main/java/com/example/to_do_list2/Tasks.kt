package com.example.to_do_list2

data class Tasks(
    val name: String = "",
    var isCompleted: Boolean = false,
    val notes: String = "",
    val hasDueDate: Boolean = true,
    val dueDate: com.google.firebase.Timestamp = com.google.firebase.Timestamp.now()
)
