package com.cooptech.collagephotoeditor.collageMaker.utils

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.cooptech.collagephotoeditor.R
import com.cooptech.collagephotoeditor.collageMaker.enums.CollageBgs.Companion.getCollageBgNames
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.FileNotFoundException

object CollageBgs {

    suspend fun getAllCollageBgs(context: Context): List<Bitmap?> = withContext(Dispatchers.IO){
        val assetManager = context.assets as AssetManager
        val bgList = mutableListOf<Bitmap?>()
        try {

            val collageBgNames = getCollageBgNames()

            collageBgNames.forEach {name->
                Log.d("2903852378927389", "getAllCollageBgs: $name")
                val inputStream = assetManager.open("collage_bgs/$name")
                val bitmap = BitmapFactory.decodeStream(inputStream)
                bgList.add(bitmap)
                inputStream.close()
            }

        }catch (e: FileNotFoundException){
            Log.d("w0957235784325", "exception: ${e.message}")
        }catch (e:Exception){
            Log.d("w0957235784325", "exception: ${e.message}")
        }

        bgList.toList()
    }

    fun getDefaultCollageBg(context: Context): Bitmap?{
        val assetManager = context.assets as AssetManager
        var bitmap: Bitmap? = null
        try {
            val inputStream = assetManager.open("collage_bgs/collage_bg_1.webp")
            bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()
            return bitmap
        }catch (e: FileNotFoundException){
            Log.d("w0957235784325", "exception: ${e.message}")
        }
        return bitmap
    }

}