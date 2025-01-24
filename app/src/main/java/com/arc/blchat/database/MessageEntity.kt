package com.arc.blchat.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val sender:String, // "LEFT" or "RIGHT"
    val message: String,
    val timestamp: Long = System.currentTimeMillis()
)
