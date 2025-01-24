package com.arc.blchat

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.arc.blchat.fragments.LeftFragment
import com.arc.blchat.fragments.RightFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val viewPager:ViewPager2 = findViewById(R.id.viewPager)
        val adapter = ChatPagerAdapter(this)
        viewPager.adapter = adapter
    }
}

class ChatPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity){
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return if(position == 0) LeftFragment() else RightFragment()
    }

}