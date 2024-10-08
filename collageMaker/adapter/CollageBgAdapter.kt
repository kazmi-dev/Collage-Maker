package com.cooptech.collagephotoeditor.collageMaker.adapter

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.cooptech.collagephotoeditor.R
import com.cooptech.collagephotoeditor.databinding.ItemCollageBgBinding

class CollageBgAdapter(
    private val onItemClick: (Bitmap?) -> Unit
): RecyclerView.Adapter<CollageBgAdapter.MyViewHolderClass>() {

    private val adapterData = mutableListOf<Bitmap?>()
    private var selectedPosition = 0

    inner class MyViewHolderClass(private val binding: ItemCollageBgBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Bitmap?){
            binding.imageBg.setImageBitmap(item)
            if (selectedPosition == adapterPosition){
                binding.collageBg.strokeColor = ResourcesCompat.getColor(itemView.resources, R.color.card_blue_light, null)
            }else{
                binding.collageBg.strokeColor = ResourcesCompat.getColor(itemView.resources, R.color.transparent, null)
            }
            binding.bgView.setOnClickListener {
                selectedPosition = adapterPosition
                notifyDataSetChanged()
                onItemClick(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderClass {
        return MyViewHolderClass(ItemCollageBgBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = adapterData.size

    override fun onBindViewHolder(holder: MyViewHolderClass, position: Int) {
        holder.bind(adapterData[position])
    }

    fun setAdapter(list: List<Bitmap?>){
        adapterData.clear()
        adapterData.addAll(list)
        notifyDataSetChanged()
    }

}