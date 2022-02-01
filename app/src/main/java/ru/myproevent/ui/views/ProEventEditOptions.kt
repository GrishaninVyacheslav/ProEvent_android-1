package ru.myproevent.ui.views

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


class ProEventEditOptions : ConstraintLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        removeAllViews()

//        val cancelButtonParams = cancelButton.layoutParams as LayoutParams
//        cancelButtonParams.leftToLeft= rootView.id
//        cancelButtonParams.topToBottom = rootView.id
//        cancelButtonParams.bottomToBottom = rootView.id
//        cancelButton.layoutParams = cancelButtonParams
//
//        val saveButtonParams = saveButton.layoutParams as LayoutParams
//        cancelButtonParams.rightToRight = rootView.id
//        cancelButtonParams.topToBottom = rootView.id
//        cancelButtonParams.bottomToBottom = rootView.id
//        saveButton.layoutParams = saveButtonParams

//        val constraintSet = ConstraintSet()
//        constraintSet.clone(this)
//        constraintSet.connect(
//            cancelButton.id,
//            ConstraintSet.LEFT,
//            ConstraintSet.PARENT_ID,
//            ConstraintSet.LEFT,
//            0
//        )
//        constraintSet.connect(
//            cancelButton.id,
//            ConstraintSet.TOP,
//            ConstraintSet.PARENT_ID,
//            ConstraintSet.TOP,
//            0
//        )
////        constraintSet.connect(
////            saveButton.id,
////            ConstraintSet.RIGHT,
////            rootView.id,
////            ConstraintSet.RIGHT,
////            0
////        )
//        constraintSet.applyTo(this)

        addView(cancelButton)
        addView(saveButton)

    }

    private val cancelButton = TextView(context).apply {
        id = generateViewId()
        text = "Отменить"
    }
    private val saveButton = TextView(context).apply {
        id = generateViewId()
        text = "Сохранить"
    }
}