package com.example.cryptinfo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cryptinfo.R
import com.example.cryptinfo.adapter.BaseAdapter
import com.example.cryptinfo.adapter.CurrenciesAdapter
import com.example.cryptinfo.di.App
import com.example.cryptinfo.mvp.contract.CurrenciesContract
import com.example.cryptinfo.mvp.presenter.CurrenciesPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class CurrenciesListFragment : BaseListFragment(), CurrenciesContract.View {

    @Inject
    lateinit var presenter: CurrenciesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currencies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        presenter.attach(this)
        presenter.makeList()
    }

    override fun createAdapterInstance(): BaseAdapter<*> {
        return CurrenciesAdapter()
    }
    //добавление новый элементов в список
    override fun addCurrency(currency: CurrenciesAdapter.Currency) {
        viewAdapter.add(currency)
    }
    //оповещение адаптера о добавлении
    override fun notifyAdapter() {
        viewAdapter.notifyDataSetChanged()
    }
    //показываем прогресс бар
    override fun showProgress() {
        requireActivity().progress.visibility = View.VISIBLE
    }
    //прячем прогресс бар
    override fun hideProgress() {
        requireActivity().progress.visibility = View.INVISIBLE
    }
    //Toast с ошибкой
    override fun showErrorMessage(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
    //обновление списка. очищаем адаптер и обновляем его
    override fun refresh() {
        viewAdapter.items.clear()
        viewAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

}