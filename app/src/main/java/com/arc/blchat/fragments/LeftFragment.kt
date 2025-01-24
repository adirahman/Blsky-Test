package com.arc.blchat.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arc.blchat.R
import com.arc.blchat.adapter.ChatAdapter
import com.arc.blchat.viewmodel.ChatViewModel

class LeftFragment : Fragment() {
    private lateinit var viewModel: ChatViewModel
    private lateinit var adapter:ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_left, container, false)
        viewModel = ViewModelProvider(requireActivity())[ChatViewModel::class.java]
        adapter = ChatAdapter()

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val editText: EditText = view.findViewById(R.id.editText)
        val sendButton: Button = view.findViewById(R.id.sendButton)

        viewModel.allMessages.observe(viewLifecycleOwner){messages ->
            val filteredMessages = messages.filter { it.sender == "LEFT" || it.sender == "RIGHT" }
            Log.d("LeftFragment", "Submitting messages: $filteredMessages")
            adapter.submitList(filteredMessages)
        }

        sendButton.setOnClickListener{
            val message = editText.text.toString()
            if(message.isNotBlank()){
                viewModel.sendMessage("LEFT",message)
                editText.text.clear()
            }
        }

        return view
    }

}