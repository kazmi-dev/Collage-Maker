package com.cooptech.collagephotoeditor.collageMaker.model

import com.google.gson.annotations.SerializedName

class GalleryAlbum(
    @SerializedName("mAlbumId") var mAlbumId: Long,
    @SerializedName("mAlbumName") var mAlbumName: String
) {

    @SerializedName("mImageList")
    var mImageList: ArrayList<String> = ArrayList()

    @SerializedName("mTakenDate")
    lateinit var mTakenDate: String

}