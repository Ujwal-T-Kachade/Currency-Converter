package com.example.currencyconverter

import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            var selection1 : Int = 0
            var selection2 : Int = 0
            var ans : Double = 0.0
            var from : String = "ujwal"
            var to : String = " pj"


        spCurrencyfrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent != null) {
                    selection1 = position
                    from = parent.getItemAtPosition(position).toString()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }



        spCurrencyto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                if (parent != null) {
                    selection2 = position
                    to = parent.getItemAtPosition(position).toString()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        convertButton.setOnClickListener {
            val value = findViewById(R.id.value) as EditText
            val num  = value.text.toString()
            val x :Int = num.toInt()
            ans =   convert(x,selection1,selection2)
            finalAns.text = "$x $from  =  $ans $to"

            spCurrencyto.setSelection(0)
            spCurrencyfrom.setSelection(0)
        }



    }




    fun  convert(x : Int , selection1 : Int , selection2 :Int) : Double{
       var ans : Double = 0.0
        when (selection1){
            1->{
                when(selection2){
                    1->{ans = x * 1.0}
                    2->{ans = x*0.014}
                    3->{ans = x*0.011}
                    4->{ans = x*1.42}
                }

            }
            2->{
                when(selection2){
                    1->{ans = x*72.96}
                    2->{ans = x * 1.0}
                    3->{ans = x*0.82}
                    4->{ans = x*103.58}
                }

            }
            3->{
                when(selection2){
                    1->{ans = x*88.75}
                    2->{ans = x*1.22}
                    3->{ans = x * 1.0}
                    4->{ans = x*126.02}
                }

            }
            4->{
                when(selection2){
                    1->{ans = x*0.75}
                    2->{ans = x*0.0097}
                    3->{ans = x*0.0079}
                    4->{ans = x * 1.0}
                }

            }

        }
        return ans

    }


}