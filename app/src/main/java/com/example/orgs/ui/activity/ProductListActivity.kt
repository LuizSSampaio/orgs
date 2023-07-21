package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.DAOProducts
import com.example.orgs.ui.recyclerView.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductListActivity : AppCompatActivity() {
    private val recyclerAdapter = ProductListAdapter(this, DAOProducts().getAllItems())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        configureFAB()
    }

    override fun onResume() {
        super.onResume()
        updateRecyclerView()
    }

    private fun updateRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.itemList)
        recyclerAdapter.update(DAOProducts().getAllItems())
        recyclerView.adapter = recyclerAdapter
    }

    private fun configureFAB() {
        val goToFormFAB = findViewById<FloatingActionButton>(R.id.goToFormFAB)
        goToFormFAB.setOnClickListener {
            goToFormView()
        }
    }

    private fun goToFormView() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent)
    }
}
