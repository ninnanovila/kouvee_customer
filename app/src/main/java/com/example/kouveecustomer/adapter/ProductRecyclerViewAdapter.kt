package com.example.kouveecustomer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kouveecustomer.R
import com.example.kouveecustomer.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import java.util.ArrayList

class ProductRecyclerViewAdapter(private val listener: (Product) -> Unit): RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder>() {

    private var products: List<Product> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(viewHolder)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(products[position],listener)
    }

    fun setProducts(productsList: List<Product>){
        products = productsList
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private var baseUrl: String = "https://gregpetshop.berusahapastibisakok.tech/api/product/photo/"
        private var photo = itemView.findViewById<ImageView>(R.id.photo)
        private var name = itemView.findViewById<TextView>(R.id.name)
        private var price = itemView.findViewById<TextView>(R.id.price)
        private var stock = itemView.findViewById<TextView>(R.id.stock)

        fun bindItem(product: Product, listener: (Product) -> Unit){

            product.photo.let { Picasso.get().load(baseUrl+it).fit().into(photo) }
            name.text = product.name
            val priceP = product.price.toString()
            val rp = "Rp. $priceP"
            price.text = rp
            stock.text = product.stock.toString()

            containerView.setOnClickListener {
                listener(product)
            }
        }
    }


}