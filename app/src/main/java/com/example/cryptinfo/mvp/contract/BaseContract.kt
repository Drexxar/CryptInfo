package com.example.cryptinfo.mvp.contract

import com.example.cryptinfo.fragments.CurrenciesListFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class BaseContract {

    interface View

    abstract class Presenter<V: View>{
        private val subscriptions = CompositeDisposable()
        protected lateinit var view: V

        //Подписка и отписка потоков данных
        fun subscribe (subscription: Disposable){
            subscriptions.add(subscription)
        }

        fun unsubscribe(){
            subscriptions.clear()
        }

        //Прикрепление и открепление View
        fun attach(view: V){
            this.view = view
        }

        fun detach(){
            unsubscribe()
        }
    }
}