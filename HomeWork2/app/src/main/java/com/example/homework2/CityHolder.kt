package com.example.homework2

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.homework2.databinding.ItemCityBinding

class CityHolder(
    private val binding: ItemCityBinding,
    private val glide: RequestManager,
    private val onItemClick: (City) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    fun onBind(city: City) {
        with(binding) {
            tvName.text = city.name
            tvCountry.text = city.country
            root.setOnClickListener {
                onItemClick(city)
            }

            glide
                .load(city.url)
                .placeholder(R.drawable.derevnya)
                .error(R.drawable.derevnya)
                .into(ivCover)
        }
    }
}