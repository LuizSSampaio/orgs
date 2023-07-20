package com.example.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Products
import com.example.orgs.ui.recyclerView.adapter.ProductListAdapter
import java.math.BigDecimal

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.itemList)
        recyclerView.adapter = ProductListAdapter(
            this, listOf(
                Products(
                    "Apple",
                    "A big bag of apples",
                    BigDecimal("5.0")
                ),
                Products(
                    "Orange",
                    "A big bag of oranges",
                    BigDecimal("7.0")
                ),
                Products(
                    "Banana",
                    "A big bag of bananas",
                    BigDecimal("10.0")
                )
            )
        )
    }
}