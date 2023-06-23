package uz.gitamy.lesson46customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import uz.gita.myapplication.MyBoardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewm = MyBoardView(this)
        setContentView(R.layout.activity_main)

//        val speedometr =  findViewById<MySpeedomert>(R.id.speedometr)
//        val seekBar = findViewById<SeekBar>(R.id.seekBar)
//        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                speedometr.setCurrentSpeed(progress)
////                speedometer.speedTo(50f,progress.toLong())
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//
//            }
//        })



        }
}