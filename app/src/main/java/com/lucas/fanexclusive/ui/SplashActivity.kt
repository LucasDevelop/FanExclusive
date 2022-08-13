package com.lucas.fanexclusive.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.lucas.fanexclusive.R
import com.lucas.fanexclusive.ext.gone
import com.lucas.fanexclusive.wiget.TypingView

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val typingView by lazy { findViewById<TypingView>(R.id.v_typing) }
    private val envelopeView by lazy { findViewById<ImageView>(R.id.v_envelope) }
    private val musicView by lazy { findViewById<ImageView>(R.id.v_music) }
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        musicView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_music))
        envelopeView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_envelope_no_open))
        envelopeView.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_envelope_open))
            handler.postDelayed({
                envelopeView.gone()
                typingView.starPlayText("现在市面上直播类的应用可以说是一抓一大把，随随便便就以什么主题来开发个直播App，说白了就想在这领域分杯羹。在使用这些应用过程中其实不难发现，在所有的直播界面，少不了的就是各种打赏、各种点赞。")
            }, 500)
        }
    }

}