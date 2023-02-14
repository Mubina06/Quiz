package com.example.quiz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var question: TextView
    lateinit var r1: RadioButton
    lateinit var r2: RadioButton
    lateinit var r3: RadioButton
    lateinit var r4: RadioButton
    lateinit var next: Button
    lateinit var group: RadioGroup
    lateinit var layout: LinearLayout

    var index=0
    var savollar = arrayListOf<Test>()
    var z = 0
    var q1 = 0
    var q2 = 0
    var q3 = 0
    var q4 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        question = findViewById<TextView>(R.id.question)
        r1 = findViewById<RadioButton>(R.id.r1)
        r2 = findViewById<RadioButton>(R.id.r2)
        r3 = findViewById<RadioButton>(R.id.r3)
        r4 = findViewById<RadioButton>(R.id.r4)
        next = findViewById<Button>(R.id.next)
        group = findViewById<RadioGroup>(R.id.group)
        layout = findViewById<LinearLayout>(R.id.layout)

        savollar.add(
            Test(
                "2+3",
                "5",
                "3",
                "1",
                "23",
                "5"
            )
        )

        savollar.add(
            Test(
                "8+2",
                "6",
                "82",
                "10",
                "2",
                "5"
            )
        )

        savollar.add(
            Test(
                "2*4",
                "2",
                "8",
                "11",
                "10",
                "6"
            )
        )

        question(0)
        questionNumber(savollar.size)



        r1.setOnClickListener {
            if (index == 0 && q1 == 0) {
                q1++
                z++
            }
            if (index == 1 && q2 > 0) {
                z--
            }
            if (index == 2 && q3 == 0) {
                q3++
                z++
            }
            if (index == 3 && q4 > 0) {
                z--
            }
        }

        r2.setOnClickListener {
            if (index == 0 && q1 > 0) {
                z--
            }
            if (index == 1 && q2 == 0) {
                q2++
                z++
            }
            if (index == 2 && q3 > 0) {
                z--
            }
            if (index == 3 && q4 > 0) {
                z--
            }
        }

        r3.setOnClickListener {
            if (index == 0 && q1 > 0) {
                z--
            }
            if (index == 1 && q2 > 0) {
                z--
            }
            if (index == 2 && q3 > 0) {
                z--
            }
            if (index == 3 && q4 == 0) {
                q4++
                z++
            }
        }
        r4.setOnClickListener {
            if (index == 0 && q1 > 0) {
                z--
            }
            if (index == 1 && q2 > 0) {
                z--
            }
            if (index == 2 && q3 > 0) {
                z--
            }
            if (index == 3 && q4 > 0) {
                z--
            }
        }

        next.setOnClickListener {
            if (index == 2) {
                index = 0
                question(index)
                group.clearCheck()
            } else {
                index++
                question(index)
                group.clearCheck()

            }
        }
    }

        fun question(index:Int){
            var test1=savollar[index]
            question.text=test1.savol
            r1.text=test1.variant1
            r2.text=test1.variant2
            r3.text=test1.variant3
            r4.text=test1.variant4

        }


        fun questionNumber(n:Int){
            for (i in 1..n){
                var btn = Button(this)
                btn.id = i
                btn.text = "$i"
                btn.tag = "$i"
                btn.setOnClickListener(this)
                btn.setBackgroundColor(Color.rgb( 93, 155, 164))
                btn.setOnClickListener(this)
                btn.setTextColor(Color.rgb(251, 251, 251))
                btn.setTextSize(20.0F)
                layout.addView(btn)
            }

        }

    override fun onClick(p0: View?) {
        val btn = findViewById<Button>(p0!!.id)
        this.index = btn.tag.toString().toInt()-1
        question(index)
        group.clearCheck()

    }

}