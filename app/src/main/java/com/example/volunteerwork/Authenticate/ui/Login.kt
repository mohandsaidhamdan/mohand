package com.example.volunteerwork.Authenticate.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.volunteerwork.api.Links
import com.example.volunteerwork.databinding.ActivityLoginBinding
import org.json.JSONObject


class Login : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val btnlogin = binding.btnLogin

        btnlogin.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            if (username.isEmpty() ){
                Toast.makeText(this, "Enter Username please", Toast.LENGTH_SHORT).show()
            }else if (password.isEmpty()){
                Toast.makeText(this, "Enter Password please", Toast.LENGTH_SHORT).show()
            }else{
                login(username , password)
            }
        }

    }

    @SuppressLint("NotConstructor")
    private fun login(username:String, password :String) {
        val queue = Volley.newRequestQueue(this)
        val params = HashMap<String, String>()
        params["username"] = username
        params["password"] = password
        val jsonObjectRequest = object : JsonObjectRequest(
            Method.POST, Links().linkAuthenticate, JSONObject(params as Map<*, *>?),
            Response.Listener<JSONObject> { response ->
                // Handle the successful response
                Log.d("response", response.toString())
                if (response.getString("jwtToken") != null ){

                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                // Handle the error response
                Toast.makeText(this, "Error in username or password", Toast.LENGTH_SHORT).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/json"
                return headers
            }
        }
//assda
// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)

    }
}