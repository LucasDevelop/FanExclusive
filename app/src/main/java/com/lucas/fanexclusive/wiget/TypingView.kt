package com.lucas.fanexclusive.wiget

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * @author lucas
 * @since 2022/6/2.
 * @des 打字效果View
 */
class TypingView : AppCompatTextView, Runnable {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mHandler = Handler(Looper.getMainLooper())
    private var contentText = ""
    private var index = 0

    //开始播放文字
    fun starPlayText(content: String) {
        contentText = content
        mHandler.post(this)
    }

    override fun run() {
        if (index >= contentText.length) {
            mHandler.removeCallbacks(this)
            return
        }
        text = contentText.substring(IntRange(0, index++))
        mHandler.postDelayed(this,200)
    }
}