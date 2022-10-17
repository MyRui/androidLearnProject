package com.max.loan.animate

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.max.loan.R
import kotlinx.android.synthetic.main.activity_property_animate.*

//https://juejin.im/post/6846687601118691341
class PropertyAnimateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_animate)

        addImageView.setOnClickListener {
            val objectAnimator = ObjectAnimator.ofFloat(
                moveView,
                View.TRANSLATION_X,
                0f,
                -210f
            )
            objectAnimator.start()
        }
        imitatePddNewAccountRedEnvelope()
    }

    private fun imitatePddNewAccountRedEnvelope() {
        val objectAnimator1 = ObjectAnimator.ofFloat(
            newTv,
            View.TRANSLATION_Y,
            0f,
            -20f
        )
        objectAnimator1.duration = 1000
        objectAnimator1.repeatCount = -1


        val objectAnimator2 = ObjectAnimator.ofFloat(
            peopleTv,
            View.TRANSLATION_Y,
            0f,
            -20f
        )
        objectAnimator2.duration = 1000

        val objectAnimator3 = ObjectAnimator.ofFloat(
            liTv,
            View.TRANSLATION_Y,
            0f,
            -20f
        )
        objectAnimator3.duration = 1000

        val objectAnimator4 = ObjectAnimator.ofFloat(
            pgTv,
            View.TRANSLATION_Y,
            0f,
            -20f
        )
        objectAnimator4.duration = 1000

        val animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim_circle)
        dismantle.startAnimation(animation)

        objectAnimator1.start()
        objectAnimator2.start()
        objectAnimator3.start()
        objectAnimator4.start()
    }
}