package com.dr.learndemo.animate

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import com.dr.learndemo.R
import kotlinx.android.synthetic.main.activity_view_animate.*

class ViewAnimateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_animate)

        rotateAnimatorShow()
        alphaAnimatorShow()
        translateAnimatorShow()
        scaleAnimatorShow()
        tweenSetAnimatorShow()
        animateDrawableShow()
    }

    private fun rotateAnimatorShow() {
        val animatorXml = AnimationUtils.loadAnimation(this, R.anim.rotate_anim)
        rotateImageXml.startAnimation(animatorXml)

        val animateRotate = RotateAnimation(
            360f,
            0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animateRotate.repeatCount = -1
        animateRotate.duration = 1000
        animateRotate.interpolator = LinearInterpolator()
        rotateImage.startAnimation(animateRotate)
    }


    private fun alphaAnimatorShow() {
        val animatorXml = AnimationUtils.loadAnimation(this, R.anim.alpha_anim)
        alphaImageXml.startAnimation(animatorXml)

        val animatorAlpha = AlphaAnimation(0f, 1f)
        animatorAlpha.repeatCount = -1
        animatorAlpha.duration = 4000
        alphaImage.startAnimation(animatorAlpha)
    }

    private fun translateAnimatorShow() {
        val animatorXml = AnimationUtils.loadAnimation(this, R.anim.translate_anim)
        translateImageXml.startAnimation(animatorXml)

        val animatorTranslate = TranslateAnimation(0f, 120f, 0f, 120f)
        animatorTranslate.repeatCount = -1
        animatorTranslate.duration = 5000
        translateImage.startAnimation(animatorTranslate)
    }

    private fun scaleAnimatorShow() {
        val animatorXml = AnimationUtils.loadAnimation(this, R.anim.scale_anim)
        scaleImageXml.startAnimation(animatorXml)

        val animatorScale = ScaleAnimation(1f, 0f, 1f, 0f)
        animatorScale.repeatCount = -1
        animatorScale.duration = 5000
        scaleImage.startAnimation(animatorScale)
    }

    private fun tweenSetAnimatorShow() {
        val animatorXml = AnimationUtils.loadAnimation(this, R.anim.tween_set_anim)
        tweenSetImageXml.startAnimation(animatorXml)

        val animateRotate = RotateAnimation(
            360f,
            0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animateRotate.repeatCount = -1
        animateRotate.duration = 1000
        animateRotate.interpolator = LinearInterpolator()

        val animatorAlpha = AlphaAnimation(0f, 1f)
        animatorAlpha.repeatCount = -1
        animatorAlpha.duration = 4000
        alphaImage.startAnimation(animatorAlpha)

        val animatorTranslate = TranslateAnimation(0f, 120f, 0f, 120f)
        animatorTranslate.repeatCount = -1
        animatorTranslate.duration = 5000
        translateImage.startAnimation(animatorTranslate)

        val animatorScale = ScaleAnimation(1f, 0f, 1f, 0f)
        animatorScale.repeatCount = -1
        animatorScale.duration = 5000
        scaleImage.startAnimation(animatorScale)

        val animatorSet = AnimationSet(true)
        animatorSet.addAnimation(animateRotate)
        animatorSet.addAnimation(animatorAlpha)
        animatorSet.addAnimation(animatorTranslate)
        animatorSet.addAnimation(animatorScale)
        tweenSetImage.startAnimation(animatorSet)
    }

    private fun animateDrawableShow() {
        val animationDrawable = AnimationDrawable()
        var id = 0
        for (i in 0 until 60) {
            id = resources.getIdentifier("p$i", "drawable", packageName)
            animationDrawable.addFrame(resources.getDrawable(id), 50)
        }

        drawableImage.setImageDrawable(animationDrawable);
        animationDrawable.isOneShot = false;
        animationDrawable.start();
    }
}