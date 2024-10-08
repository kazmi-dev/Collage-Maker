package com.cooptech.collagephotoeditor.collageMaker.model

import com.google.gson.annotations.SerializedName

class FilterData(
    @SerializedName("text") var text: String,
    @SerializedName("red") var red: Float,
    @SerializedName("green") var green: Float,
    @SerializedName("blue") var blue: Float,
    @SerializedName("saturation") var saturation: Float
) {

}