package com.namchok.practiceapplication.customview

import android.content.Context
import android.widget.TextView
import android.widget.LinearLayout
import android.view.LayoutInflater
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import com.namchok.practiceapplication.R


class DoubleTextview : LinearLayout {
    var layout: LinearLayout? = null
    var leftTextView: TextView? = null
    var rightTextView: TextView? = null
    var mContext: Context? = null

    constructor(context: Context?) : super(context) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.DoubleText)
        var leftText = a.getString(R.styleable.DoubleText_leftText)
        var rightText = a.getString(R.styleable.DoubleText_rightText)
        leftText = leftText ?: ""
        rightText = rightText ?: ""
        val service: String = Context.LAYOUT_INFLATER_SERVICE
        val li = getContext().getSystemService(service) as LayoutInflater
        layout = li.inflate(R.layout.view_double_textview, this, true) as LinearLayout?
        leftTextView = layout?.findViewById<View>(R.id.left_text) as TextView
        rightTextView = layout?.findViewById<View>(R.id.right_text) as TextView
        leftTextView?.text = leftText
        rightTextView?.text = rightText
        a.recycle()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        mContext = context
    }

    var leftText: String?
        get() = leftTextView?.text.toString()
        set(text) {
            leftTextView?.text = text
        }
    var rightText: String?
        get() = rightTextView?.text.toString()
        set(text) {
            rightTextView?.text = text
        }
}