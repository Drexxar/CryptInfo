package com.example.cryptinfo.mvp.contract

class LatestChartContract {

    //добавление даты и значения, функции прогрессбара, показ ошибки, обновление
    interface View : BaseContract.View{
        fun addEntryToChart(value: Float, date: String = "")
        fun addEntryToChart(date: Float, value: Float)
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    //Создание и обновление
    abstract class Presenter: BaseContract.Presenter<View>(){
        abstract fun makeChart(id: String)
        abstract fun refreshChart()
    }
}