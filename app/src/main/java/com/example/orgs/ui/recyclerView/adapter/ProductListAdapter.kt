package com.example.orgs.ui.recyclerView.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.databinding.ProductItemBinding
import com.example.orgs.model.Products

class ProductListAdapter(
    private val context: Context,
    products: List<Products>
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    private val products = products.toMutableList()

    class ViewHolder(binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val itemName = binding.itemName
        private val itemContent = binding.itemContent
        private val itemPrice = binding.itemPrice

        fun link(product: Products) {
            itemName.text = product.name
            itemContent.text = product.description
            itemPrice.text = "\$${product.price.toPlainString()}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.link(product)
    }

    fun update(products: List<Products>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}
