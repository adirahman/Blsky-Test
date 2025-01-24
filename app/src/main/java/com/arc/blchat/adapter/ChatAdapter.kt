package com.arc.blchat.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arc.blchat.R
import com.arc.blchat.database.MessageEntity

class ChatAdapter : ListAdapter<MessageEntity, ChatAdapter.ChatViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message,parent,false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message = getItem(position)
        Log.d("ChatAdapter", "Binding message: $message")
        Log.d("ChatAdapter", "Binding message at position $position: $message")
        holder.bind(message)
    }

    override fun submitList(list: List<MessageEntity>?) {
        Log.d("ChatAdapter", "New list submitted: $list")
        super.submitList(list)
    }


    class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val messageTextView: TextView = itemView.findViewById(R.id.text_message)
        private val timeStampTextView: TextView = itemView.findViewById(R.id.text_timestamp)
        private val senderTextView: TextView = itemView.findViewById(R.id.text_sender)

        fun bind(message: MessageEntity){
            messageTextView.text = message.message
            timeStampTextView.text = formatTimeStamp(message.timestamp)
            senderTextView.text = if (message.sender == "LEFT") "Left" else "Right"
        }

        private fun formatTimeStamp(timeStamp:Long): String{
            val sdf = java.text.SimpleDateFormat("HH:mm:ss",java.util.Locale.getDefault())
            return sdf.format(java.util.Date(timeStamp))
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<MessageEntity>(){
        override fun areItemsTheSame(oldItem: MessageEntity, newItem: MessageEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MessageEntity, newItem: MessageEntity): Boolean {
            return oldItem == newItem
        }

    }
}