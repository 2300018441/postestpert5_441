package com.pmob.baseproj5

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class EditPostActivity : AppCompatActivity() {

    private lateinit var imgPreview: ImageView
    private var imageUri: Uri? = null
    private var position: Int = -1

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) {
        imageUri = it
        imgPreview.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_post)

        position = intent.getIntExtra("position", -1)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etCaption = findViewById<EditText>(R.id.etCaption)
        val btnAddImage = findViewById<Button>(R.id.btnAddImage)
        val btnSave = findViewById<Button>(R.id.btnSave)
        imgPreview = findViewById(R.id.imgPreview)

        btnAddImage.setOnClickListener {
            pickImage.launch("image/*")
        }

        btnSave.setOnClickListener {
            val intent = Intent()
            intent.putExtra("position", position)
            intent.putExtra("username", etUsername.text.toString())
            intent.putExtra("caption", etCaption.text.toString())
            intent.putExtra("imageUri", imageUri)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
