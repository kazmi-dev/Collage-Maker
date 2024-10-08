package com.cooptech.collagephotoeditor.collageMaker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cooptech.collagephotoeditor.R
import com.cooptech.collagephotoeditor.collageMaker.model.TemplateItem
import com.cooptech.collagephotoeditor.databinding.ItemFrameBinding
import com.photoeditor.photoeffect.utils.PhotoUtils

class CollageFrameAdapter(
    private val onFrameClick:(TemplateItem)->Unit
): RecyclerView.Adapter<CollageFrameAdapter.MyViewHolderClass>() {

    private val adapterData = arrayListOf<TemplateItem>()
    private var lastPosition = 0
    private var selectedPosition = 0

    inner class MyViewHolderClass(private val binding: ItemFrameBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TemplateItem){
            binding.apply {

                PhotoUtils.loadImageWithGlide(itemView.context, binding.imgFrame, item.preview)

                if (selectedPosition == adapterPosition){
                    frameBg.strokeColor = itemView.context.resources.getColor(R.color.card_blue_light, null)
                }else{
                    frameBg.strokeColor = itemView.context.resources.getColor(R.color.transparent, null)
                }

                imgFrame.setOnClickListener {
                    selectedPosition = adapterPosition
                    if(lastPosition == -1)
                        lastPosition = selectedPosition
                    else {
                        notifyItemChanged(lastPosition, Any())
                        lastPosition = selectedPosition
                    }
                    notifyItemChanged(selectedPosition)
                    onFrameClick(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderClass {
        return MyViewHolderClass(ItemFrameBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = adapterData.size

    override fun onBindViewHolder(holder: MyViewHolderClass, position: Int) {
        holder.bind(adapterData[position])
    }

    fun setAdapterData(list: ArrayList<TemplateItem>){
//        val diffUtil = FrameDiffUtil(adapterData, list)
//        val diffResult = DiffUtil.calculateDiff(diffUtil)
//        adapterData.clear()
//        adapterData.addAll(list)
//        diffResult.dispatchUpdatesTo(this)

        adapterData.clear()
        adapterData.addAll(list)
        notifyDataSetChanged()

    }

//    inner class FrameDiffUtil(
//        private val oldList: ArrayList<TemplateItem>,
//        private val newList: ArrayList<TemplateItem>
//    ): DiffUtil.Callback(){
//        override fun getOldListSize(): Int = oldList.size
//
//        override fun getNewListSize(): Int = newList.size
//
//        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//            return oldList[oldItemPosition] == newList[newItemPosition]
//        }
//
//        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//            return oldList[oldItemPosition].isSelected == newList[newItemPosition].isSelected
//        }
//
//    }

}