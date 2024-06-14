package com.mcal.uidesigner.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout

class IncludeLayout : LinearLayout {
    private lateinit var mContext: Context
    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    private fun init(context: Context) {
        mContext = context
        orientation = VERTICAL
    }

    fun setLayout(layout: CharSequence) {
    }
}