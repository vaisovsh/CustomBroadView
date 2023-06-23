package uz.gitamy.lesson46customview

import android.content.Context
import android.graphics.Canvas
import android.view.View
import android.widget.ImageView
import java.util.jar.Attributes

class MySwitchButton @JvmOverloads constructor(
    context: Context,
    attributes: Attributes ?= null
): View(context) {

    val isSwitch=false
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (isSwitch){
            setBackgroundResource(R.drawable.on)
        }else{
            setBackgroundResource(R.drawable.off)
        }

        invalidate()
    }
}