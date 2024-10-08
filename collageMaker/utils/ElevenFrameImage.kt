package com.cooptech.collagephotoeditor.collageMaker.utils

import android.graphics.PointF
import com.cooptech.collagephotoeditor.collageMaker.model.TemplateItem
import com.cooptech.collagephotoeditor.collageMaker.template.PhotoItem
import com.photoeditor.photoeffect.utils.FrameImageUtils
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

object ElevenFrameImage {

    internal fun collage_11_8(): TemplateItem {
        val item = FrameImageUtils.collage("collage_11_8.png")
        //first frame
        var photoItem = PhotoItem()
        photoItem.index = 0
        photoItem.bound.set(0f, 0f, 0.2f, 0.2f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        //second frame
        photoItem = PhotoItem()
        photoItem.index = 1
        photoItem.bound.set(0.2f, 0f, 1f, 0.2f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        //third frame
        photoItem = PhotoItem()
        photoItem.index = 2
        photoItem.bound.set(0f, 0.2f, 0.2f, 0.5f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        //fourth frame
        photoItem = PhotoItem()
        photoItem.index = 3
        photoItem.bound.set(0.2f, 0.2f, 0.5f, 0.8f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        //fifth frame
        photoItem = PhotoItem()
        photoItem.index = 4
        photoItem.bound.set(0.5f, 0.2f, 0.8f, 0.8f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        //sixth frame
        photoItem = PhotoItem()
        photoItem.index = 5
        photoItem.bound.set(0f, 0.5f, 0.2f, 0.8f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        //seventh frame
        photoItem = PhotoItem()
        photoItem.index = 6
        photoItem.bound.set(0.8f, 0.2f, 1f, 0.5f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        //eighth frame
        photoItem = PhotoItem()
        photoItem.index = 7
        photoItem.bound.set(0.8f, 0.5f, 1f, 0.8f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        //ninth frame
        photoItem = PhotoItem()
        photoItem.index = 8
        photoItem.bound.set(0f, 0.8f, 0.7f, 1f)  // Adjusted width to make space for 11th image
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        //tenth frame
        photoItem = PhotoItem()
        photoItem.index = 9
        photoItem.bound.set(0.7f, 0.8f, 0.9f, 1f)  // Reduced width
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        //eleventh frame
        photoItem = PhotoItem()
        photoItem.index = 10
        photoItem.bound.set(0.9f, 0.8f, 1f, 1f)  // Added 11th image at the right edge
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        return item
    }

    internal fun collage_11_7(): TemplateItem {
        val item = FrameImageUtils.collage("collage_11_7.png")

        // First frame (center)
        var photoItem = PhotoItem()
        photoItem.index = 0
        photoItem.bound.set(0.33f, 0.33f, 0.66f, 0.66f) // Center image
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Top-left frame
        photoItem = PhotoItem()
        photoItem.index = 1
        photoItem.bound.set(0.33f, 0f, 0.5f, 0.33f) // Top-left
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Top-right frame
        photoItem = PhotoItem()
        photoItem.index = 2
        photoItem.bound.set(0.5f, 0f, 0.66f, 0.33f) // Top-right
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Bottom-left frame
        photoItem = PhotoItem()
        photoItem.index = 3
        photoItem.bound.set(0.33f, 0.66f, 0.5f, 1f) // Bottom-left
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Bottom-right frame
        photoItem = PhotoItem()
        photoItem.index = 4
        photoItem.bound.set(0.5f, 0.66f, 0.66f, 1f) // Bottom-right
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Left frame 1
        photoItem = PhotoItem()
        photoItem.index = 5
        photoItem.bound.set(0f, 0f, 0.33f, 0.33f) // Top-left (left column)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Left frame 2
        photoItem = PhotoItem()
        photoItem.index = 6
        photoItem.bound.set(0f, 0.33f, 0.33f, 0.66f) // Middle-left (left column)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Left frame 3
        photoItem = PhotoItem()
        photoItem.index = 7
        photoItem.bound.set(0f, 0.66f, 0.33f, 1f) // Bottom-left (left column)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Right frame 1
        photoItem = PhotoItem()
        photoItem.index = 8
        photoItem.bound.set(0.66f, 0f, 1f, 0.33f) // Top-right (right column)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Right frame 2
        photoItem = PhotoItem()
        photoItem.index = 9
        photoItem.bound.set(0.66f, 0.33f, 1f, 0.66f) // Middle-right (right column)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Right frame 3
        photoItem = PhotoItem()
        photoItem.index = 10
        photoItem.bound.set(0.66f, 0.66f, 1f, 1f) // Bottom-right (right column)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        return item
    }

    internal fun collage_11_6(): TemplateItem {
        val item = FrameImageUtils.collage("collage_11_6.png")
        // first frame
        var photoItem = PhotoItem()
        photoItem.index = 0
        photoItem.bound.set(0f, 0f, 0.5f, 0.2f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        // second frame
        photoItem = PhotoItem()
        photoItem.index = 1
        photoItem.bound.set(0.5f, 0f, 1f, 0.2f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        // third frame
        photoItem = PhotoItem()
        photoItem.index = 2
        photoItem.bound.set(0f, 0.2f, 0.33f, 0.4f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        // fourth frame
        photoItem = PhotoItem()
        photoItem.index = 3
        photoItem.bound.set(0.33f, 0.2f, 0.66f, 0.4f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        // fifth frame
        photoItem = PhotoItem()
        photoItem.index = 4
        photoItem.bound.set(0.66f, 0.2f, 1f, 0.4f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        // sixth frame
        photoItem = PhotoItem()
        photoItem.index = 5
        photoItem.bound.set(0f, 0.4f, 0.5f, 0.6f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        // seventh frame
        photoItem = PhotoItem()
        photoItem.index = 6
        photoItem.bound.set(0.5f, 0.4f, 1f, 0.6f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        // eighth frame
        photoItem = PhotoItem()
        photoItem.index = 7
        photoItem.bound.set(0f, 0.6f, 0.33f, 0.8f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        // ninth frame
        photoItem = PhotoItem()
        photoItem.index = 8
        photoItem.bound.set(0.33f, 0.6f, 0.66f, 0.8f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        // tenth frame
        photoItem = PhotoItem()
        photoItem.index = 9
        photoItem.bound.set(0.66f, 0.6f, 1f, 0.8f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)
        // eleventh frame
        photoItem = PhotoItem()
        photoItem.index = 10
        photoItem.bound.set(0f, 0.8f, 1f, 1f)
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        return item
    }

    internal fun collage_11_5(): TemplateItem {
        val item = FrameImageUtils.collage("collage_11_5.png")

        // Left side: Three large images
        // First large image
        var photoItem = PhotoItem()
        photoItem.index = 0
        photoItem.bound.set(0f, 0f, 0.5f, 0.3333f) // 50% width, 33.33% height
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Second large image
        photoItem = PhotoItem()
        photoItem.index = 1
        photoItem.bound.set(0f, 0.3333f, 0.5f, 0.6666f) // 50% width, 33.33% height
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Third large image
        photoItem = PhotoItem()
        photoItem.index = 2
        photoItem.bound.set(0f, 0.6666f, 0.5f, 1f) // 50% width, 33.33% height
        photoItem.pointList.add(PointF(0f, 0f))
        photoItem.pointList.add(PointF(1f, 0f))
        photoItem.pointList.add(PointF(1f, 1f))
        photoItem.pointList.add(PointF(0f, 1f))
        item.photoItemList.add(photoItem)

        // Right side: Eight small images in two columns and five rows
        // Loop to create 8 small images
        for (i in 0..7) {
            photoItem = PhotoItem()
            photoItem.index = 3 + i
            // Calculate row and column
            val row = i % 4 // 0 to 4 for row index
            val col = i / 4 // 0 for left column, 1 for right column

            photoItem.bound.set(
                0.5f + (col * 0.25f),  // Column offset (0.5 for left side + 0.25 for right column)
                row * 0.25f,            // Row height (5 rows, so each row is 0.2)
                0.75f + (col * 0.25f), // Width, with 0.25 for each column
                (row + 1) * 0.25f       // Height up to the next row
            )
            photoItem.pointList.add(PointF(0f, 0f))
            photoItem.pointList.add(PointF(1f, 0f))
            photoItem.pointList.add(PointF(1f, 1f))
            photoItem.pointList.add(PointF(0f, 1f))
            item.photoItemList.add(photoItem)
        }

        return item
    }

    internal fun collage_11_4(): TemplateItem {
        val item = FrameImageUtils.collage("collage_11_4.png")

        // Dimensions for the decagon
        val decagonSize = 0.3f  // 30% of the width and height
        val decagonRadius = decagonSize / 2  // Radius of the decagon

        // Create the central decagon shape
        val decagonItem = PhotoItem()
        decagonItem.index = 0
        decagonItem.bound.set(
            0.5f - decagonRadius,  // Left bound
            0.5f - decagonRadius,  // Top bound
            0.5f + decagonRadius,  // Right bound
            0.5f + decagonRadius   // Bottom bound
        )
        item.photoItemList.add(decagonItem)

        // Calculate positions for 10 images around the decagon
        val outerRadius = 0.5f;  // This will occupy the remaining space around the decagon
        val imageSize = 0.1f;     // Size of each surrounding image

        for (i in 0 until 10) {
            val angle = (i * 2 * PI / 10).toFloat() // Calculate angle in radians
            val xOffset = (outerRadius * cos(angle)); // X position offset
            val yOffset = (outerRadius * sin(angle)); // Y position offset

            val photoItem = PhotoItem()
            photoItem.index = 1 + i // Assigning indices from 1 to 10

            // Set the bounds for the surrounding images
            photoItem.bound.set(
                0.5f + xOffset - (imageSize / 2), // Centering the image on the calculated position
                0.5f + yOffset - (imageSize / 2), // Centering the image on the calculated position
                0.5f + xOffset + (imageSize / 2), // Centering the image on the calculated position
                0.5f + yOffset + (imageSize / 2)  // Centering the image on the calculated position
            )

            // Add corner points for each surrounding image
            photoItem.pointList.add(PointF(0f, 0f))
            photoItem.pointList.add(PointF(1f, 0f))
            photoItem.pointList.add(PointF(1f, 1f))
            photoItem.pointList.add(PointF(0f, 1f))
            item.photoItemList.add(photoItem)
        }

        return item
    }




}