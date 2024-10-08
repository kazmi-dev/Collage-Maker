package com.cooptech.collagephotoeditor.collageMaker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cooptech.collagephotoeditor.collageMaker.model.TemplateItem
import com.cooptech.collagephotoeditor.databinding.FrameItemBinding
import com.photoeditor.photoeffect.utils.PhotoUtils

class FramesListAdapter(
    private val context: Context,
    private val onFrameClick: (TemplateItem)->Unit
) : RecyclerView.Adapter<FramesListAdapter.MyViewHolderClass>() {

    private var adapterData = arrayListOf<TemplateItem>()

    inner class MyViewHolderClass(private val binding: FrameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TemplateItem) {

            PhotoUtils.loadImageWithGlide(context, binding.frameImage, item.preview)

            binding.frameImage.setOnClickListener {
                onFrameClick(item)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderClass {
        return MyViewHolderClass(
            FrameItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = adapterData.size

    override fun onBindViewHolder(holder: MyViewHolderClass, position: Int) {
        holder.bind(adapterData[position])
    }

    fun setAdapterData(list: ArrayList<TemplateItem>){
        adapterData = list
        notifyDataSetChanged()
    }
}