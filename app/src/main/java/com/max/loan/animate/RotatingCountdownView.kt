package com.pesogo.cashsuper

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.graphics.SweepGradient
import android.graphics.Typeface
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import kotlin.math.cos
import kotlin.math.sin
import androidx.core.graphics.toColorInt
import androidx.core.graphics.withRotation

/**
 *   <com.pesogo.cashsuper.RotatingCountdownView
android:layout_margin="20dp"
app:layout_constraintTop_toBottomOf="@id/tv01"
app:layout_constraintLeft_toLeftOf="parent"
app:layout_constraintRight_toRightOf="parent"
android:layout_width="150dp"
android:layout_height="150dp"/>
 */
class RotatingCountdownView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private val innerRadius = 90f       // 内圆半径
    private val ringWidth = 80f         // 环宽
    private val outerRadius = innerRadius + ringWidth  // 外圆半径

    private var rotateAngle = 0f        // 当前旋转角度
    private val smallBallRadius = 15f   // 小球半径

    private val animator = ValueAnimator.ofFloat(0f, 360f).apply {
        duration = 3000L   // 4秒转一圈，速度可调整
        repeatCount = ValueAnimator.INFINITE
        interpolator = LinearInterpolator()
        addUpdateListener {
            rotateAngle = it.animatedValue as Float
            invalidate()   // 刷新界面，触发 onDraw
        }
        start()
    }


    private val colors = intArrayOf(
        "#FDF8DB".toColorInt(),
        "#FEDFDC".toColorInt(),
        "#F69B80".toColorInt(),
        "#FFD356".toColorInt()
    )

    private val whitePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.WHITE
    }

    private val baseRingPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }


    private val sweepPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 3f
        color = Color.WHITE
    }

    private val smallBallPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.WHITE
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        textSize = 48f
        textAlign = Paint.Align.CENTER
        typeface = Typeface.DEFAULT_BOLD
    }

    private var countdownSeconds = 60
    private val countdownHandler = Handler(Looper.getMainLooper())
    private val countdownRunnable = object : Runnable {
        override fun run() {
            if (countdownSeconds > 0) {
                countdownSeconds--
                invalidate()
                countdownHandler.postDelayed(this, 1000)
            }
        }
    }

    init {
        countdownHandler.postDelayed(countdownRunnable, 1000)
        animator.start()

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val sweepGradient = SweepGradient(
            w / 2f, h / 2f, colors, null
        )
        sweepPaint.shader = sweepGradient
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val cx = width / 2f
        val cy = height / 2f
        if (baseRingPaint.shader == null) {
            baseRingPaint.shader = SweepGradient(
                cx, cy,
                intArrayOf(
                    "#FDF8DB".toColorInt(),
                    "#FEDFDC".toColorInt(),
                    "#FFD356".toColorInt(),
                    "#F69B80".toColorInt(),
                    "#FDF8DB".toColorInt()
                    ),
                null
            )
        }
        // 画中心白色圆
        canvas.drawCircle(cx, cy, innerRadius, whitePaint)

        // 画底色圆环（不旋转）
        val basePath = Path().apply {
            addArc(
                cx - outerRadius, cy - outerRadius,
                cx + outerRadius, cy + outerRadius,
                0f, 360f
            )
            addArc(
                cx - innerRadius, cy - innerRadius,
                cx + innerRadius, cy + innerRadius,
                0f, 360f
            )
            fillType = Path.FillType.EVEN_ODD
        }
        canvas.drawPath(basePath, baseRingPaint)

        val midRadius: Float = (innerRadius + outerRadius) / 2f
        canvas.drawCircle(cx, cy, midRadius, linePaint)

        // 小球围绕圆心匀速旋转（与扇形方向无关）
        val ballAngleRad = Math.toRadians(rotateAngle.toDouble())
        val ballCx = cx + midRadius * cos(ballAngleRad).toFloat()
        val ballCy = cy + midRadius * sin(ballAngleRad).toFloat()
        canvas.drawCircle(ballCx, ballCy, smallBallRadius, smallBallPaint)

        // 中间倒计时文字
        val textY = cy - (textPaint.descent() + textPaint.ascent()) / 2
        canvas.drawText("$countdownSeconds s", cx, textY, textPaint)
    }
}




