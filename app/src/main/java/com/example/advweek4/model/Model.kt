package com.example.advweek4.model

import com.google.gson.annotations.SerializedName

data class Student(
    val id:String?,
    val name:String?,
    @SerializedName("student_name")
    val bod:String?,
    @SerializedName("birth_of_date")
    val phone:String?,
    @SerializedName("photo_url")
    val photoUrl:String?
)