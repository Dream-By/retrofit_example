package com.example.retrofit_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofit_example.data.Books
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildService(ApiInterface::class.java)
        val call = request.getBooks()
        call.enqueue(object : Callback<List<Books>> {
            override fun onFailure(call: Call<List<Books>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Books>>, response: Response<List<Books>>) {
                TODO("Not yet implemented")
            }

        })

    }
}


