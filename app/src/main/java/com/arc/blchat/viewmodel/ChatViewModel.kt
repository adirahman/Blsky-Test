package com.arc.blchat.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.arc.blchat.database.ChatDatabase
import com.arc.blchat.database.MessageEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatViewModel(application: Application): AndroidViewModel(application) {
    private val messageDao = ChatDatabase.getInstance(application).messageDao()
    val allMessages: LiveData<List<MessageEntity>> = messageDao.getAllMessages().asLiveData()

    fun sendMessage(sender: String, message:String){
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("RoomDebug", "Message: ${message}")
            messageDao.insertMessage(MessageEntity(sender = sender, message = message))
        }
    }
}