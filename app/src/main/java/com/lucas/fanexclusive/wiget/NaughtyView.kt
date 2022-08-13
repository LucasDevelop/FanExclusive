package com.lucas.fanexclusive.wiget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.lucas.fanexclusive.R
import java.lang.RuntimeException

/**
 * @author lucas
 * @since 2022/6/2.
 * @des 调皮View
 */
class NaughtyView : FrameLayout {
    constructor(context: Context) : super(context) {
        initView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    private val contentView by lazy {
        LayoutInflater.from(context).inflate(R.layout.view_naughty, null, false) as ViewGroup
    }
    private val yesView: View by lazy { contentView.findViewById(R.id.v_yes) }
    private val noView: View by lazy { contentView.findViewById(R.id.v_no) }

    private fun initView(context: Context, attrs: AttributeSet?) {
        addView(contentView,LayoutParams(-2,-2))
        yesView.setOnClickListener {

        }

        noView.setOnClickListener {
            moveToYes()
        }
    }

    // move container from no to yes.
    private fun moveToYes() {
        val noLocation = IntArray(2)
        noView.getLocationOnScreen(noLocation)
        val yesLocation = IntArray(2)
        yesView.getLocationOnScreen(yesLocation)
        val diffX = yesLocation[0] - noLocation[0]
        val diffY = yesLocation[1] - noLocation[1]
        scrollBy(diffX, diffY)
    }


}