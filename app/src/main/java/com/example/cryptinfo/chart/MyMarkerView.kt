package com.example.cryptinfo.chart

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import com.example.cryptinfo.R
import com.example.cryptinfo.dateToString
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF

@SuppressLint
class MyMarkerView(context: Context, layoutResource: Int): MarkerView(context, layoutResource) {

    private val tvContent: TextView

    init{
        tvContent = findViewById(R.id.tvContent)
    }

    //Запускается каждый раз, когда MarkerView перерисовывается
    override fun refreshContent(e: Entry, highlight: Highlight?) {
        //заполняем поле маркера значениями графика по осям с применением форматирования
        tvContent.text = e.y.toString()+ "\n" + e.x.dateToString("MMM dd, YYYY")
        super.refreshContent(e, highlight)
    }

    //Возвращает положение маркера
    override fun getOffset(): MPPointF {
        return MPPointF((-(width/2)).toFloat(),(-height).toFloat())
    }

}