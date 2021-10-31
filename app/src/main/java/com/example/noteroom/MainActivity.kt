package com.example.noteroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

     val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }
    private lateinit var rvAdapter: RecyclerViewAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvAdapter = RecyclerViewAdapter(this)
        rvMain.adapter = rvAdapter
        rvMain.layoutManager = LinearLayoutManager(this)
            myViewModel.getNotes().observe(
              this , { Notes ->rvAdapter.update(Notes)}
           )

        addB.setOnClickListener {
            if (noteE.text.isNotEmpty()){

                myViewModel.addNote(noteE.text.toString())

            }


        }







    }}