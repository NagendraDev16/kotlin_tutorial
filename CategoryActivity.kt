package com.happycoding.rnd.mygroceryapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.happycoding.rnd.mygroceryapp.R
import com.happycoding.rnd.mygroceryapp.adapter.CategoryAdapter
import com.happycoding.rnd.mygroceryapp.dtos.Category
import com.happycoding.rnd.mygroceryapp.dtos.ProductCategory
import com.happycoding.rnd.mygroceryapp.service.AppNavigator
import com.happycoding.rnd.mygroceryapp.service.OnCategorySelected
import com.happycoding.rnd.mygroceryapp.util.SpacesItemDecoration
import kotlinx.android.synthetic.main.activity_category.*


class CategoryActivity : AppCompatActivity(), OnCategorySelected {

    lateinit var categories: ArrayList<Category>
    lateinit var productCategory: ProductCategory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        productCategory = intent.extras?.get("productCategory") as ProductCategory
        toolbar.title = productCategory.name
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        getCategories()
        initRecyclerView()
    }

    fun getCategories() {
        categories = ArrayList()
        var imageVeg =
            resources.getIdentifier("onion", "raw", packageName)
        categories.add(Category(id = 1, name = "Vegetable", hindiName = "Sabji", image = imageVeg))
        var imageAta =
            resources.getIdentifier("ata", "raw", packageName)
        categories.add(Category(id = 1, name = "Flour", hindiName = "Ata", image = imageAta))
        var imageDal =
            resources.getIdentifier("dal", "raw", packageName)
        categories.add(Category(id = 2, name = "Pulse", hindiName = "Dal", image = imageDal))
        var imageDryFruits =
            resources.getIdentifier("dry_fruits", "raw", packageName)
        categories.add(
            Category(
                id = 1,
                name = "Dry Fruits",
                hindiName = "Dry Fruits",
                image = imageDryFruits
            )
        )
        var imageMasala =
            resources.getIdentifier("masala", "raw", packageName)
        categories.add(Category(id = 1, name = "Spice", hindiName = "Masala", image = imageMasala))
        var imageOils =
            resources.getIdentifier("oil", "raw", packageName)
        categories.add(
            Category(
                id = 1,
                name = "Oils",
                hindiName = "Tel and Ghee",
                image = imageOils
            )
        )
        var imageOrganicStaples =
            resources.getIdentifier("organic_staples", "raw", packageName)
        categories.add(
            Category(
                id = 1,
                name = "Organic Staples",
                hindiName = "",
                image = imageOrganicStaples
            )
        )
        var imageRice =
            resources.getIdentifier("rice", "raw", packageName)
        categories.add(Category(id = 1, name = "Rice", hindiName = "Chawal", image = imageRice))
        var imageSugarSalt =
            resources.getIdentifier("sugar_salt_jaggery", "raw", packageName)
        categories.add(
            Category(
                id = 1,
                name = "Sugar, Salt & Jaggery",
                hindiName = "",
                image = imageSugarSalt
            )
        )
    }

    fun initRecyclerView() {
        val adapter = CategoryAdapter(this, categories)
        rvProductCategories.addItemDecoration(SpacesItemDecoration(3, 50, false))
        rvProductCategories.layoutManager = GridLayoutManager(this, 3)
        rvProductCategories.adapter = adapter
    }

    override fun categorySelected(category: Category) {
        AppNavigator.openProductActivity(this, category)
    }

    override fun categorySelected(id: ProductCategory) {
        TODO("Not yet implemented")
    }
}
