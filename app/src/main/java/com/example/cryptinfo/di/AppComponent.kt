package com.example.cryptinfo.di

import com.example.cryptinfo.activities.MainActivity
import com.example.cryptinfo.chart.LatestChart
import com.example.cryptinfo.fragments.CurrenciesListFragment
import com.example.cryptinfo.mvp.presenter.CurrenciesPresenter
import com.example.cryptinfo.mvp.presenter.LatestChartPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {

    //сообщаем классы для внедрения зависимостей
    fun inject(mainActivity: MainActivity)

    fun inject(presenter: CurrenciesPresenter)

    fun inject(presenter: LatestChartPresenter)

    fun inject(fragment: CurrenciesListFragment)

    fun inject(chart: LatestChart)

}