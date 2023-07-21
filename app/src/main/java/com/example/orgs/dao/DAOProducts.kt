package com.example.orgs.dao

import com.example.orgs.model.Products

class DAOProducts {

    fun addProduct(product: Products) {
        products.add(product)
    }

    fun getAllItems(): List<Products> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Products>()
    }
}