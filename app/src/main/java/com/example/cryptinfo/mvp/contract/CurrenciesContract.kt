package com.example.cryptinfo.mvp.contract

import com.example.cryptinfo.adapter.CurrenciesAdapter

class CurrenciesContract {

    //Добавление новых валют в список, оповещение адаптера, показ и скрытие прогрессбара,показ ошибки и обновление
    interface View: BaseContract.View{
        fun addCurrency(currency: CurrenciesAdapter.Currency)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    //Создание и обновление спика криптовалют
    abstract class Presenter: BaseContract.Presenter<View>(){
        abstract fun makeList()
        abstract fun refreshList()
    }
}