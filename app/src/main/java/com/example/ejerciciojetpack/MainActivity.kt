package com.example.ejerciciojetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.Gravity.LEFT
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_menuapp.*
import kotlinx.android.synthetic.main.fragment_web.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    @SuppressLint("RtlHardcoded")
    override fun onBackPressed() {
      var toas1 = Toast.makeText(getApplicationContext(),
                "atras",
                Toast.LENGTH_LONG)
         toas1.setGravity(LEFT,0,0);

        if(vWeb.canGoBack()){
            vWeb.goBack()
        }else{
            super.onBackPressed()
        }



    }


}