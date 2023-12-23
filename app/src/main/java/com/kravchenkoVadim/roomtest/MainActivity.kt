package com.kravchenkoVadim.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kravchenkoVadim.roomtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = MainDb.getDb(this)
        binding.button.setOnClickListener {
            val item = Item(
                null,
                binding.edName.text.toString(),
                binding.edPrise.text.toString()
            )
            Thread {
                db.getDao().insertItem(item)
            }.start()
        }
    }
}