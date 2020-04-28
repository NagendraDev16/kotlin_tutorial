package com.happycoding.rnd.mygroceryapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.happycoding.rnd.mygroceryapp.R
import com.happycoding.rnd.mygroceryapp.dtos.ProductCategory
import com.happycoding.rnd.mygroceryapp.service.OnCategorySelected
import com.happycoding.rnd.mygroceryapp.view.ui.home.HomeFragment
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController
import com.squareup.picasso.Picasso

class ProductCategoryAdapter(
    var context: Context?,
    var categories: ArrayList<ProductCategory>,
    var homeFragment: OnCategorySelected
) :
    RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryVH {
        val inflate: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_category_item_row, null)
        return ProductCategoryVH(inflate)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ProductCategoryVH, position: Int) {
        val productCategory = categories[position]
        holder.tvProductName.text = productCategory.name
        context?.let { Glide.with(it).load(productCategory.image).into(holder.ivProductImage) }
        holder.itemView.setOnClickListener{
            homeFragment.categorySelected(productCategory)
        }
    }

    //View Holder
    class ProductCategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvProductName = itemView.findViewById<TextView>(R.id.tvProductName)
        val ivProductImage = itemView.findViewById<ImageView>(R.id.ivProductImage)
    }
}


