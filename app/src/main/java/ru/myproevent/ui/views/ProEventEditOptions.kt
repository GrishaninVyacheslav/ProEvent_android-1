package ru.myproevent.ui.views

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import ru.myproevent.R
import ru.myproevent.domain.utils.pxValue


class ProEventEditOptions : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        removeAllViews()
        //val params = LayoutParams(hexDiameter, hexDiameter)
        addView(separator, LayoutParams(widthMeasureSpec, pxValue(2f).toInt()))
        addView(cancelButton, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply { leftMargin = pxValue(18f).toInt() })
        addView(saveButton, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
            Log.d("[MYLOG]", "MeasureSpec.getSize(${MeasureSpec.getSize(widthMeasureSpec)})")
            Log.d("[MYLOG]", "getWidth = ${getWidth()}")
            leftMargin = MeasureSpec.getSize(widthMeasureSpec) - getWidth()
        })
    }

    private val separator = View(context).apply {
        setBackgroundColor(context.getColor(R.color.ProEvent_blue_300))
    }
    private val cancelButton = TextView(context).apply {
        text = "Отменить"
    }
    private val saveButton = TextView(context).apply {
        text = "Сохранить"
    }
}