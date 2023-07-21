package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.orgs.R
import com.example.orgs.dao.DAOProducts
import com.example.orgs.model.Products
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_form)

        val nameField = findViewById<EditText>(R.id.editName)
        val descriptionField = findViewById<EditText>(R.id.editDescription)
        val priceField = findViewById<EditText>(R.id.editPrice)
        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            val priceString = priceField.text.toString()
            val price = if (priceString.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(priceString)
            }

            val newProduct = Products(
                nameField.text.toString(),
                descriptionField.text.toString(),
                price
            )
            DAOProducts().addProduct(newProduct)
            finish()
        }
    }
}