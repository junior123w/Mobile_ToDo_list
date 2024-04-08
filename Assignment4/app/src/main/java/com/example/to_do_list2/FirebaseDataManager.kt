package com.example.to_do_list2

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class FirebaseDataManager {

    private val db = FirebaseFirestore.getInstance()
    private val collectionref = db.collection("To-DoList")

    //working
    fun getTasks(onComplete: (List<Tasks>) -> Unit) {
        collectionref.get()
            .addOnSuccessListener { result ->
                val tasks = result.mapNotNull { it.toObject<Tasks>() }
                onComplete(tasks)
            }
            .addOnFailureListener {
                onComplete(emptyList())
            }
    }
    fun saveTodo(todo: Tasks, onComplete: (Boolean,Exception?) -> Unit) {
        collectionref.add(todo)
            .addOnSuccessListener {
                onComplete(true,null)
            }
            .addOnFailureListener { error ->
                onComplete(false,error)
            }
    }
}