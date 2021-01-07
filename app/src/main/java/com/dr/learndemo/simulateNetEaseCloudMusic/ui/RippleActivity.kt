package com.dr.learndemo.simulateNetEaseCloudMusic.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dr.learndemo.R
import kotlinx.android.synthetic.main.activity_ripple.*

class RippleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ripple)


        Glide.with(this)
            .load(R.drawable.test1)
            .circleCrop()
            .into(music_center)

        var rotateAnimation = ObjectAnimator.ofFloat(music_center, View.ROTATION, 0f, 360f)
        rotateAnimation.duration = 1000 * 6
        rotateAnimation.repeatCount = -1
        rotateAnimation.interpolator = LinearInterpolator()

        music_center.setOnClickListener {
            when {
                rotateAnimation.isPaused -> {
                    Log.d("zjr", "isPaused")
                    rotateAnimation.resume()
                }
                rotateAnimation.isRunning -> {
                    Log.d("zjr", "isRunning")
                    rotateAnimation.pause()
                }
                else -> {
                    Log.d("zjr", "else")
                    rotateAnimation.start()
                }
            }
        }
    }
}