package com.example.tsf_banking_app
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tsf_banking_app.adapter.ItemAdapter
import com.example.tsf_banking_app.adapter.TransactionItemAdapter
import com.example.tsf_banking_app.databinding.ActivityTransactionsBinding
import com.example.tsf_banking_app.dbHelper.DBhelper

class TransactionsActivity : AppCompatActivity() {
    private lateinit var dbHelper: DBhelper
    private lateinit var binding : ActivityTransactionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dbHelper = DBhelper(this)
        val transactionList = dbHelper.getTransaction(this)
        Toast.makeText(this@TransactionsActivity,transactionList.size.toString(),Toast.LENGTH_LONG).show()
        //Toast.makeText(this@TransactionsActivity,transactionList.size.toString(),Toast.LENGTH_LONG).show()
        val adapter = TransactionItemAdapter(this,transactionList)
        val rv = binding.transactionRecycle
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
    }
}