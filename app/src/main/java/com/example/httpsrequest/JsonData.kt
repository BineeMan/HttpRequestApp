package com.example.httpsrequest

import android.provider.ContactsContract

data class Post(
    val userId: String,
    val title: String,
    val body: String,
)

data class Person (
    val name: String,
    val email: String,

)