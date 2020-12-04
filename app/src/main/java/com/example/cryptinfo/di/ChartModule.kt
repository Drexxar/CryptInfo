package com.example.cryptinfo.di

import com.example.cryptinfo.YearValueFormatter
import com.example.cryptinfo.chart.LatestChart
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ChartModule {
    @Provides
    @Singleton
    fun provideLatestChart() = LatestChart()

    @Provides
    @Singleton
    fun provideYearFormatter() = YearValueFormatter()
}