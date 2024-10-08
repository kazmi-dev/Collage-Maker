package com.cooptech.collagephotoeditor.collageMaker.enums

enum class CollageBgs(val fileName: String) {
    BG_1("collage_bg_1.webp"),
    BG_2("collage_bg_2.webp"),
    BG_3("collage_bg_3.webp"),
    BG_4("collage_bg_4.webp"),
    BG_5("collage_bg_5.webp"),
    BG_6("collage_bg_6.webp"),
    BG_7("collage_bg_7.webp"),
    BG_8("collage_bg_8.webp"),
    BG_9("collage_bg_9.webp"),
    BG_10("collage_bg_10.webp"),
    BG_11("collage_bg_11.webp"),
    BG_12("collage_bg_12.webp"),
    BG_13("collage_bg_13.webp"),
    BG_14("collage_bg_14.webp"),
    BG_15("collage_bg_15.webp"),
    BG_16("collage_bg_16.webp"),
    BG_17("collage_bg_17.webp"),
    BG_18("collage_bg_18.webp"),
    BG_19("collage_bg_19.webp"),
    BG_20("collage_bg_20.webp"),
    BG_21("collage_bg_21.webp"),
    BG_22("collage_bg_22.webp"),
    BG_23("collage_bg_23.webp"),
    BG_24("collage_bg_24.webp"),
    BG_25("collage_bg_25.webp");

    companion object {
        fun getCollageBgNames(): List<String> {
            return entries.map { it.fileName }
        }

    }

}