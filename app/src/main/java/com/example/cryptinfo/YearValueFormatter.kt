package com.example.cryptinfo

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import java.util.*

//Класс для преобразования даты с помощью функций в строковый формат для отрисовки легенды оси Х графика цны криптовалюты
class YearValueFormatter : IAxisValueFormatter {

    override fun getFormattedValue(value: Float, axis: AxisBase?): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = value.toLong()
        return calendar.toFormatter()
    }

    fun Calendar.toFormatter(): String{
        val date = this.timeInMillis
        return date.dateToString("MMM yyyy")
    }
}