package com.example.studentxmlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var RVstudent : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RVstudent = findViewById(R.id.rvMain)

        var students: List<Students>? = null


        try {
            val parser = MyXmlPullParserHandler()
            val istream = assets.open("student.xml")
            students=  parser.parse(istream)

            RVstudent.adapter = myAdapter(students)
            RVstudent.layoutManager = LinearLayoutManager(this)

        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}