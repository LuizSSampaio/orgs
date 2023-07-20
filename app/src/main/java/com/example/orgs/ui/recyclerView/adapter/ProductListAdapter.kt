package com.example.orgs.ui.recyclerView.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Products

class ProductListAdapter(
    private val context: Context,
    private val products: List<Products>
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun link(product: Products) {
            val itemName = itemView.findViewById<TextView>(R.id.itemName)
            val itemContent = itemView.findViewById<TextView>(R.id.itemContent)
            val itemPrice = itemView.findViewById<TextView>(R.id.itemPrice)
            itemName.text = product.name
            itemContent.text = product.description
            itemPrice.text = "\$${product.price.toPlainString()}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.link(product)
    }

}
