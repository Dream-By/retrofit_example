package com.example.retrofit_example

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_example.data.Book
import com.example.retrofit_example.data.Books
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()

        val request = retrofit.create(ApiInterface::class.java)

        val call = request.getBooks()
        call.enqueue(object : Callback <List<Book>> {

            override fun onResponse(call: Call <List<Book>>, response: Response <List<Book>>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "is Successful", Toast.LENGTH_SHORT).show()
                    System.out.println("isSuccessful - ")
                    val bookArrayList: List<Book>? = response.body()
                    if (bookArrayList != null) {
                        Handler(Looper.getMainLooper()).post {

                            textView.text = bookArrayList.map (Book::title).joinToString ("\n" )
                        }
                    } else Toast.makeText(this@MainActivity, "ArrayList is Null", Toast.LENGTH_SHORT).show()
                }
                else Toast.makeText(this@MainActivity, "Response is Not Successful", Toast.LENGTH_SHORT).show()
            }


                override fun onFailure(call: Call <List<Book>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_LONG).show()
                    System.out.println("Error_message - " + t.message)
                }
            })

        button2.setOnClickListener{
            val delFragment = DelFragment()
            val booksforDel = Bundle()
            booksforDel.putStringArrayList("books",booksforDel as ArrayList<String>)
            delFragment.setArguments(booksforDel)
            val manager = supportFragmentManager
            delFragment.show(manager,"Delete Book")
        }

    }

    fun delBooks (itemId : Int){

    }
}




