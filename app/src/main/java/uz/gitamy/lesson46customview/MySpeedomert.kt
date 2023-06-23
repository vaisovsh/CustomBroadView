package uz.gitamy.lesson46customview
//
//import android.annotation.SuppressLint
//import android.content.Context
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.graphics.Rect
//import android.graphics.RectF
//import android.util.AttributeSet
//import android.view.View
//import kotlin.math.cos
//import kotlin.math.max
//import kotlin.math.min
//import kotlin.math.sin
//
//class MySpeedomert @JvmOverloads constructor(
//    context: Context,
//    attrs: AttributeSet? = null,
//    defStyle: Int = 0
//): View(context, attrs, defStyle) {
//    private val maxSpeed = 180
//    private var currentSpeed = 0
//
//    private val paint = Paint().apply {
//        strokeWidth = 16f
//        style = Paint.Style.STROKE
//        color = Color.GREEN
//    }
//
//    private val paintFill = Paint().apply {
//        style = Paint.Style.FILL
//        color = Color.GREEN
//    }
//
//    @SuppressLint("DrawAllocation")
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//
//        val x = width / 2f
//        val y = height* 1f
//        val radius = min(x, y)
//
//        val rect = RectF(0f + 16f, 0f + 16f, 2*radius - 16f, 2*radius)
//        canvas.drawArc(rect, 180f, 180f, false, paint)
//
//        canvas.drawCircle(radius, radius, 20f, paintFill)
//
//        val angle =   Math.PI - Math.PI * currentSpeed / maxSpeed
//
//        val endX = radius +  cos(angle) * radius - 20f
//        val endY = radius - sin(angle) * radius + 20f
//
//        canvas.drawLine(radius, radius, endX.toFloat(), endY.toFloat() , paintFill)
//    }
//
//
//    fun setCurrentSpeed(speed: Int) {
//        if (speed in 1 until maxSpeed) {
//            currentSpeed = speed
//            invalidate()
//        }
//    }
//}


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class MySpeedomert @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {
    private val maxSpeed = 180
    private var currentSpeed = 0
    private val paint = Paint().apply {
        strokeWidth = 16f
        style = Paint.Style.STROKE
        color = Color.YELLOW
    }
    private val paintText = Paint().apply {
        style = Paint.Style.FILL
        color = Color.RED
        isAntiAlias = true
        textSize = 30f
    }
    private val paintText_no = Paint().apply {
        style = Paint.Style.FILL
        color = Color.GREEN
        isAntiAlias = true
        textSize = 40f
    }

    private val paintFill = Paint().apply {
        style = Paint.Style.STROKE
        isAntiAlias = true
        strokeWidth = 8f
        color = Color.BLACK
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val x = width / 2f
        val y = height * 1f
        val radius = min(x, y)

        val rect = RectF(0f + 16f, 0f + 16f, 2 * radius - 16f, 2 * radius)
        canvas.drawArc(rect, 180f, 180f, false, paint)

        canvas.drawCircle(radius, radius, 20f, paintFill)

        for (i in 0..18) {
            val angle = Math.PI - Math.PI * i / 18
            val startX = radius + cos(angle) * radius
            val startY = radius - sin(angle) * radius
            val endX = startX - 30f * cos(angle)
            val endY = startY + 30f * sin(angle)

            canvas.drawLine(startX.toFloat(), startY.toFloat(), endX.toFloat(), endY.toFloat(), paintFill)

            val number = (i * 10).toString()
            val bounds = Rect()
            paintText.getTextBounds(number, 0, number.length, bounds)
            val textX = startX - bounds.width() / 2f
            val textY = endY + bounds.height() + 20f // Adjusted coordinate

            canvas.drawText(number, textX.toFloat(), textY.toFloat(), paintText)
        }

        val angle = Math.PI - Math.PI * currentSpeed / maxSpeed
        val endX = radius + cos(angle) * radius - 50f * cos(angle)
        val endY = radius - sin(angle) * radius + 50f * sin(angle)
        canvas.drawLine(radius, radius, endX.toFloat(), endY.toFloat(), paintFill)
        canvas.drawText("$currentSpeed", x - 30f, y - 30f, paintText)
    }





    fun setCurrentSpeed(speed: Int) {
        if (speed in 1 until maxSpeed) {
            currentSpeed = speed
            invalidate()
        }
    }


}


