package com.cooptech.collagephotoeditor.ui.fragments.collage_screens

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.cooptech.collagephotoeditor.R
import com.cooptech.collagephotoeditor.collageMaker.adapter.CollageBgAdapter
import com.cooptech.collagephotoeditor.collageMaker.adapter.CollageFrameAdapter
import com.cooptech.collagephotoeditor.collageMaker.frame.FramePhotoLayout
import com.cooptech.collagephotoeditor.collageMaker.model.TemplateItem
import com.cooptech.collagephotoeditor.collageMaker.multitouch.PhotoView
import com.cooptech.collagephotoeditor.databinding.ScreenCollageBinding
import com.cooptech.collagephotoeditor.mvvm.viewmodel.MainViewModel
import com.cooptech.collagephotoeditor.collageMaker.utils.CollageBgs
import com.cooptech.collagephotoeditor.utils.CustomToast.Companion.shortToast
import com.photoeditor.photoeffect.utils.ImageUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Collage : Fragment() {

    private val binding by lazy {
        ScreenCollageBinding.inflate(layoutInflater)
    }
    private val controller by lazy {
        Navigation.findNavController(requireActivity(), R.id.navHostFragment)
    }
    private val args by navArgs<CollageArgs>()
    private val viewModel by activityViewModels<MainViewModel>()

    private var mOutputScale = 1f
    private var selectedTemplateItem: TemplateItem? = null
    private val framesList = arrayListOf<TemplateItem>()

    private lateinit var mPhotoView: PhotoView
    private var mFramePhotoLayout: FramePhotoLayout? = null
    private lateinit var collageFrameAdapter: CollageFrameAdapter
    private lateinit var collageBgAdapter: CollageBgAdapter

    private var DEFAULT_SPACE: Float = 0.0f
    private var MAX_SPACE: Float = 0.0f
    private var MAX_CORNER: Float = 0.0f

    private val MAX_SPACE_PROGRESS = 300.0f
    private val MAX_CORNER_PROGRESS = 200.0f
    private val RATIO_SQUARE = 0
    private val RATIO_GOLDEN = 2
    private var mSpace = DEFAULT_SPACE
    private var mCorner = 0f

    private var mLayoutRatio = RATIO_SQUARE

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            DEFAULT_SPACE = ImageUtils.pxFromDp(requireContext(), 2F)
            MAX_SPACE = ImageUtils.pxFromDp(requireContext(), 30F)
            MAX_CORNER = ImageUtils.pxFromDp(requireContext(), 60F)
            mSpace = DEFAULT_SPACE

            initFrameRv()
            btnClicks()

        }
    }

    private fun initCollageBgRv() {
        binding.bgLoading.isVisible = true
        collageBgAdapter = CollageBgAdapter { bg ->
            setBackgroundImageCollage(bg)
        }
        binding.bgCollageRv.apply {
            val layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            this.layoutManager = layoutManager
            adapter = collageBgAdapter
            hasFixedSize()
        }
        viewModel.loadCollageBgs {
            collageBgAdapter.setAdapter(it)
        }
        binding.bgCollageRv.isVisible = true
        binding.bgLoading.isVisible = false
    }

    private fun initCollageLayout() {
        viewModel.getDefaultCollageBg {
            setBackgroundImageCollage(it)
        }
        mPhotoView = PhotoView(requireContext())
        binding.rlContainer.viewTreeObserver
            .addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    mOutputScale = ImageUtils.calculateOutputScaleFactor(
                        binding.rlContainer.width,
                        binding.rlContainer.height
                    )
                    if (selectedTemplateItem == null) {
                        shortToast("selected template item is null")
                    } else {
                        buildLayout(selectedTemplateItem!!)
                    }
                    // remove listener
                    binding.rlContainer.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            })
    }

    private fun setBackgroundImageCollage(collageBgImage: Bitmap?) {
        binding.imgBackground.load(collageBgImage)
    }

    private fun buildLayout(selectedTemplateItem: TemplateItem) {
        Log.d("9023748325788437", "buildLayout: started")
        mFramePhotoLayout = FramePhotoLayout(requireContext(), selectedTemplateItem.photoItemList)

        var viewWidth = binding.rlContainer.width
        var viewHeight = binding.rlContainer.height
        if (mLayoutRatio === RATIO_SQUARE) {
            if (viewWidth > viewHeight) {
                viewWidth = viewHeight
            } else {
                viewHeight = viewWidth
            }
        } else if (mLayoutRatio === RATIO_GOLDEN) {
            val goldenRatio = 1.61803398875
            if (viewWidth <= viewHeight) {
                if (viewWidth * goldenRatio >= viewHeight) {
                    viewWidth = (viewHeight / goldenRatio).toInt()
                } else {
                    viewHeight = (viewWidth * goldenRatio).toInt()
                }
            } else if (viewHeight <= viewWidth) {
                if (viewHeight * goldenRatio >= viewWidth) {
                    viewHeight = (viewWidth / goldenRatio).toInt()
                } else {
                    viewWidth = (viewHeight * goldenRatio).toInt()
                }
            }
        }
        Log.d("9023748325788437", "viewWidth: $viewWidth")
        mOutputScale = ImageUtils.calculateOutputScaleFactor(viewWidth, viewHeight)
        mFramePhotoLayout!!.build(viewWidth, viewHeight, mOutputScale, mSpace, mCorner)

        //get params for relative layout
        val params = RelativeLayout.LayoutParams(viewWidth, viewHeight)
        params.addRule(RelativeLayout.CENTER_IN_PARENT)
        binding.rlContainer.removeAllViews()

        //remove background view if exist and add new one
        binding.rlContainer.removeView(binding.imgBackground)
        binding.rlContainer.addView(binding.imgBackground, params)

        //add frame layout
        binding.rlContainer.addView(mFramePhotoLayout, params)

        //add sticker view
        binding.rlContainer.removeView(mPhotoView)
        binding.rlContainer.addView(mPhotoView, params)

        //reset space and corner seek bars
        binding.spaceSeekBar.progress = (MAX_SPACE_PROGRESS * mSpace / MAX_SPACE).toInt()
        binding.cornerSeekbar.progress = (MAX_CORNER_PROGRESS * mCorner / MAX_CORNER).toInt()
        binding.cornerSeekbarValue.text = "%.0f".format(mCorner)
        binding.spaceSeekbarValue.text = "%.0f".format(mSpace)
    }

    private fun initFrameRv() {
        binding.framesView.isVisible = true
        binding.frameLoading.isVisible = true

        //initialize Frame adapter
        if (binding.collageFrameRv.adapter == null) {
            collageFrameAdapter = CollageFrameAdapter(
                onFrameClick = { item ->
                    onFrameClicked(item)
                }
            )
            binding.collageFrameRv.apply {
                val layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                this.layoutManager = layoutManager
                adapter = collageFrameAdapter
                hasFixedSize()
            }

            viewModel.loadFramesImages { collageFrames ->

                //get frames w.r.t image count
                if (args.imageCount > 0) {
                    collageFrames.forEach { item ->
                        if (item.photoItemList.size == args.imageCount) {
                            framesList.add(item)
                            return@forEach
                        }
                    }
                } else {
                    framesList.addAll(collageFrames)
                }

                Log.d("9023748325788437", "template list : $framesList")

                //selected frame 1 as default
                selectedTemplateItem = framesList[0]

                //set to adapter
                collageFrameAdapter.setAdapterData(framesList)
                binding.collageFrameRv.isVisible = true
                binding.frameLoading.isVisible = false

                //set images as selected images
                args.selectedImages.forEachIndexed { index, item ->
                    selectedTemplateItem?.photoItemList?.get(index)?.imagePath = item
                }

                //build collage layout
                initCollageLayout()
            }
        }


    }

    private fun onFrameClicked(item: TemplateItem) {
        selectedTemplateItem = item
        //set images as selected images
        args.selectedImages.forEachIndexed { index, path ->
            selectedTemplateItem?.photoItemList?.get(index)?.imagePath = path
        }
        buildLayout(selectedTemplateItem!!)
    }

    private fun btnClicks() {

        binding.backBtn.setOnClickListener {
            controller.popBackStack()
        }

        binding.cLayoutTab.setOnClickListener {
            updateTab(isLayout = true)
        }

        binding.cMarginsTab.setOnClickListener {
            updateTab(isMargins = true)
        }

        binding.cBackgroundTab.setOnClickListener {
            updateTab(isBackground = true)
            if (binding.bgCollageRv.adapter == null){
                initCollageBgRv()
            }
        }

        binding.spaceSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, isChanging: Boolean) {
                mSpace = MAX_SPACE * progress / MAX_SPACE_PROGRESS
                binding.spaceSeekbarValue.text = "%.0f".format(mSpace)
                mFramePhotoLayout?.setSpace(mSpace, mCorner)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })

        binding.cornerSeekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, isChanging: Boolean) {
                mCorner = MAX_CORNER * progress / MAX_CORNER_PROGRESS
                binding.cornerSeekbarValue.text = "%.0f".format(mCorner)
                mFramePhotoLayout?.setSpace(mSpace, mCorner)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })

        binding.saveBtn.setOnClickListener {
            viewModel.finalCollageImageBitmap = createOutputImage()
            controller.navigate(R.id.action_collage_to_finalCollageImage)
        }


    }

    private fun updateTab(
        isLayout: Boolean = false,
        isMargins: Boolean = false,
        isBackground: Boolean = false,
    ) {
        when {
            isLayout -> {
                binding.apply {
                    cLayoutTabBorder.isVisible = true
                    cMarginTabBorder.isVisible = false
                    cBackgroundTabBorder.isVisible = false
                    framesView.isVisible = true
                    marginsLayout.isVisible = false
                    bgView.isVisible = false
                }
            }

            isMargins -> {
                binding.apply {
                    cLayoutTabBorder.isVisible = false
                    cMarginTabBorder.isVisible = true
                    cBackgroundTabBorder.isVisible = false
                    framesView.isVisible = false
                    marginsLayout.isVisible = true
                    bgView.isVisible = false
                }
            }

            isBackground -> {
                binding.apply {
                    cLayoutTabBorder.isVisible = false
                    cMarginTabBorder.isVisible = false
                    cBackgroundTabBorder.isVisible = true
                    framesView.isVisible = false
                    marginsLayout.isVisible = false
                    bgView.isVisible = true
                }
            }
        }
    }

    private fun createOutputImage(): Bitmap {
        return try {
            val template = mFramePhotoLayout!!.createImage()
            val collageFinalImage =
                Bitmap.createBitmap(template.width, template.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(collageFinalImage)
            val paint = Paint(Paint.ANTI_ALIAS_FLAG)
            val collageBgImage = binding.imgBackground.drawable
            val collageBgBitmap = (collageBgImage as BitmapDrawable).bitmap
            canvas.drawBitmap(
                collageBgBitmap,
                Rect(0, 0, collageBgBitmap.width, collageBgBitmap.height),
                Rect(0, 0, collageFinalImage.width, collageFinalImage.height),
                paint
            )
            canvas.drawBitmap(template, 0f, 0f, paint)
            template.recycle()
            val stickers = mPhotoView.getImage(mOutputScale)
            canvas.drawBitmap(stickers!!, 0f, 0f, paint)
            stickers.recycle()
            System.gc()
            collageFinalImage
        } catch (error: OutOfMemoryError) {
            error.printStackTrace()
            val collageBgImage = binding.imgBackground.drawable
            (collageBgImage as BitmapDrawable).bitmap
        } catch (e: NullPointerException) {
            e.printStackTrace()
            val collageBgImage = binding.imgBackground.drawable
            (collageBgImage as BitmapDrawable).bitmap
        }
    }


}