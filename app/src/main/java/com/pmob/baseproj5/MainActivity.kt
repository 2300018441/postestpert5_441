package com.pmob.baseproj5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pmob.baseproj5.adapter.PostAdapter
import com.pmob.baseproj5.adapter.StoryAdapter
import com.pmob.baseproj5.model.Post
import com.pmob.baseproj5.model.Story


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Data Story
        val storyList = listOf(
            Story("intan_dwi", R.drawable.intan_dwi),
            Story("minda_04", R.drawable.minda_04),
            Story("rubi_community", R.drawable.ruby_community),
            Story("rizka", R.drawable.rizka),
            Story("amelia", R.drawable.amelia)
        )

        // Data Post
        val postList = listOf(
            Post("Pantai Selatan", "Nikmati indahnya pantai di sore hari", R.drawable.pantai),
            Post("Senja di Bukit", "Langit oranye yang menenangkan hati", R.drawable.senja),
            Post("Teman Seperjalanan", "Perjalanan lebih seru bersama teman", R.drawable.teman)
        )

        // Inisialisasi Story RecyclerView
        val storyRecycler = findViewById<RecyclerView>(R.id.recyclerStories)
        storyRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        storyRecycler.adapter = StoryAdapter(storyList)

        // Inisialisasi Post RecyclerView
        val postRecycler = findViewById<RecyclerView>(R.id.recyclerView)
        postRecycler.layoutManager = LinearLayoutManager(this)
        postRecycler.adapter = PostAdapter(postList)

        // Floating Button (contoh fungsinya bisa disesuaikan)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
        fabAdd.setOnClickListener {
            // Contoh aksi: tampilkan pesan atau buka halaman tambah post
        }
    }
}
