package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.dao.DAOProducts
import com.example.orgs.databinding.ActivityProductListBinding
import com.example.orgs.ui.recyclerView.adapter.ProductListAdapter

class ProductListActivity : AppCompatActivity() {
    private val recyclerAdapter = ProductListAdapter(this, DAOProducts().getAllItems())
    private lateinit var binding: ActivityProductListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureFAB()
    }

    override fun onResume() {
        super.onResume()
        updateRecyclerView()
    }

    private fun updateRecyclerView() {
        val recyclerView = binding.itemList
        recyclerAdapter.update(DAOProducts().getAllItems())
        recyclerView.adapter = recyclerAdapter
    }

    private fun configureFAB() {
        val goToFormFAB = binding.goToFormFAB
        goToFormFAB.setOnClickListener {
            goToFormView()
        }
    }

    private fun goToFormView() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent)
    }
}
