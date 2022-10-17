package com.max.loan.simulateNetEaseCloudMusic.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.max.loan.simulateNetEaseCloudMusic.bean.Particle
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

//https://juejin.im/post/6871049441546567688
class RippleView(context: Context?, attributeSet: AttributeSet?) : View(context, attributeSet) {
    private val pathCircleRadius = 280f//中心圆半径
    private val offsetMaxRange = 200//最大偏移距离
    private val maxOffsetMaxRange = 500//最大距离
    private val maxNumberParticle = 1000//粒子个数
    private var particleList = mutableListOf<Particle>()
    var paint = Paint()
    var centerX: Float = 0.0f
    var centerY: Float = 0.0f
    var path = Path()
    private val pathMeasure = PathMeasure()
    var pos = FloatArray(2)
    private val tan = FloatArray(2)

    private var animator = ValueAnimator.ofFloat(0f, 1f)

    init {
        animator.duration = 2000
        animator.repeatCount = -1
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener {
            updateParticle()
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.WHITE
        paint.isAntiAlias = true
        particleList.forEach {
            paint.alpha = it.alpha
            canvas.drawCircle(it.x, it.y, it.radius, paint)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = (w / 2).toFloat()
        centerY = (h / 2).toFloat()
        path.addCircle(centerX, centerY, pathCircleRadius, Path.Direction.CCW)
        pathMeasure.setPath(path, false)
        var nextX: Float
        var speed: Float
        var nextY: Float
        var angle: Double
        var offSet: Int
        var maxOffset: Int
        for (i in 0..maxNumberParticle) {
            pathMeasure.getPosTan(i / maxNumberParticle.toFloat() * pathMeasure.length, pos, tan)
            nextX = pos[0] + Random.nextInt(6) - 3f
            nextY = pos[1] + Random.nextInt(6) - 3f
            angle = acos(((pos[0] - centerX) / pathCircleRadius).toDouble())
            speed = createSpeed()
            offSet = Random.nextInt(offsetMaxRange)
            maxOffset = Random.nextInt(maxOffsetMaxRange)
            particleList.add(
                Particle(nextX, nextY, 2f, speed, 100, offSet, angle, maxOffset.toFloat())
            )
        }
        animator.start()
    }

    private fun updateParticle() {
        particleList.forEach { particle ->
            if (particle.offset > particle.maxOffset) {
                particle.offset = 0
                particle.speed = createSpeed()
            }
            particle.alpha = ((1f - particle.offset / particle.maxOffset) * 225f).toInt()
            particle.x =
                (centerX + cos(particle.angle) * (pathCircleRadius + particle.offset)).toFloat()
            if (particle.y > centerY) {
                particle.y =
                    (sin(particle.angle) * (pathCircleRadius + particle.offset) + centerY).toFloat()
            } else {
                particle.y =
                    (centerY - sin(particle.angle) * (pathCircleRadius + particle.offset)).toFloat()
            }
            particle.offset += particle.speed.toInt()
        }
    }

    private fun createSpeed(): Float {
        return (Random.nextInt(3) + 1).toFloat();
    }
}