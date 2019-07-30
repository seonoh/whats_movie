package com.eamcoding.whatsmovie.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.eamcoding.whatsmovie.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        go_movie.setOnClickListener {
            val movieIntent = Intent(this,MovieActivity::class.java)
            startActivity(movieIntent)
        }


    }
}
