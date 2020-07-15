package com.example.retrofit_example

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_example.data.Book
import com.example.retrofit_example.data.Books
import kotlinx.android.synthetic.main.activity_main.*
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

            override fun onResponse(call: Call<List<Books>>, response: Response<List<Books>>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()
                    val bookArrayList: List<Books>? = response.body()
                    if (bookArrayList != null) {
                        Handler(Looper.getMainLooper()).post {
                            //textView.text = bookArrayList.get(i).books.joinToString("\n")
                            textView.text = bookArrayList.map { Book::title }.toString()
                        }
                    } else Toast.makeText(this@MainActivity, "ArrayList is Null", Toast.LENGTH_SHORT).show()
                }
                else Toast.makeText(this@MainActivity, "Response is Not Successful", Toast.LENGTH_SHORT).show()
            }

                override fun onFailure(call: Call<List<Books>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })

    }
}


