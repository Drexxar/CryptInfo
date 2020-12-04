package com.example.cryptinfo.chart

import android.content.Context
import android.graphics.Color
import com.example.cryptinfo.R
import com.example.cryptinfo.YearValueFormatter
import com.example.cryptinfo.di.App
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import javax.inject.Inject

class LatestChart {

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var formatter: YearValueFormatter

    lateinit var chart: LineChart

    init {
        App.appComponent.inject(this)
    }

    //Инициализация графика
    fun initChart(chart: LineChart){
        this.chart = chart

        chart.description.isEnabled = false

        chart.setTouchEnabled(true)

        chart.isDragEnabled = true
        chart.setScaleEnabled(false)
        chart.isScaleXEnabled = true
        chart.setDrawGridBackground(false)
        chart.isDoubleTapToZoomEnabled = false

        chart.setPinchZoom(false)
        chart.maxHighlightDistance = 300F

        //инкапсулируем данные графика
        val data = LineData()
        data.setValueTextColor(Color.BLACK)

        //отрисовываем график
        chart.data = data
        chart.legend.isEnabled = true

        chart.setDrawMarkers(true)
        chart.marker = MyMarkerView(context, R.layout.custom_marker_view)

        val xl = chart.xAxis
        xl.textColor = Color.BLACK
        xl.position = XAxis.XAxisPosition.BOTTOM
        xl.setDrawGridLines(false)
        xl.valueFormatter = formatter
        xl.labelCount = 3
        xl.granularity = 48F

        xl.setAvoidFirstLastClipping(true)
        xl.isEnabled = true

        val leftAxis = chart.axisLeft
        leftAxis.textColor = Color.BLACK
        leftAxis.setDrawGridLines(true)

        val rightAxis = chart.axisRight
        rightAxis.isEnabled = true
    }

    //Добавление данных на график
    fun addEntry(value: Float, date: Float){
        val data = chart.data

        if (data != null){

            var set: ILineDataSet? = data.getDataSetByIndex(0)

            if(set == null){
                set = createSet()
                data.addDataSet(set)
            }

            data.addEntry(Entry(date, value), 0)
            data.notifyDataChanged()
            chart.notifyDataSetChanged()
            //смещение графика по оси Х и инициирует обновление
            chart.moveViewToX(date)
            //выделяет значение у при данном значении х в данном наборе данных
            chart.highlightValue(date,0)
        }
    }

    //Создание и настройка набора данных
    private fun createSet(): LineDataSet {
        val set = LineDataSet(null, "Цена, USD")
        set.mode = LineDataSet.Mode.CUBIC_BEZIER
        set.cubicIntensity = 0.2f
        set.setDrawFilled(true)
        set.setDrawCircles(false)
        set.lineWidth = 1.8f
        set.circleRadius = 4f
        set.setCircleColor(Color.BLACK)
        set.highlightLineWidth = 1.2f
        set.highLightColor = context.resources.getColor(R.color.colorPrimary)
        set.color = Color.BLACK
        set.fillColor = Color.WHITE
        set.enableDashedHighlightLine(10f, 5f, 0f)
        set.fillAlpha = 100
        set.setDrawHorizontalHighlightIndicator(true)
        set.setFillFormatter { _, _ ->
            chart.axisLeft.axisMinimum
        }
        return set
    }
}