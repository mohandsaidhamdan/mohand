package com.example.volunteerwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volunteerwork.Authenticate.ui.Login
import com.example.volunteerwork.api.Links
import com.example.volunteerwork.databinding.ActivityLoginBinding
import com.example.volunteerwork.databinding.ActivityMainBinding

import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnLogin = binding.btnlogin
        btnLogin.setOnClickListener {
            startActivity(Intent(this , Login::class.java))
        }

    }



}