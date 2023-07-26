package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.orgs.R
import com.example.orgs.dao.DAOProducts
import com.example.orgs.databinding.ActivityProductFormBinding
import com.example.orgs.model.Products
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureImageSelector()
        configureSaveButton()
    }

    private fun configureImageSelector() {
        val imageSelector = binding.imageSelector
        imageSelector.setOnClickListener {
            AlertDialog.Builder(this)
                .setView(R.layout.image_form)
                .setPositiveButton("Save") {_, _ ->

                }
                .setNegativeButton("Cancel") {_, _ ->

                }
                .show()
        }
    }

    private fun configureSaveButton() {
        val saveButton = binding.saveButton
        saveButton.setOnClickListener {
            val newProduct = createProduct()
            DAOProducts().addProduct(newProduct)
            finish()
        }
    }

    private fun createProduct(): Products {
        val nameField = binding.editName
        val descriptionField = binding.editDescription
        val priceField = binding.editPrice
        val priceString = priceField.text.toString()
        val price = if (priceString.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(priceString)
        }

        return Products(
            nameField.text.toString(),
            descriptionField.text.toString(),
            price
        )
    }
}