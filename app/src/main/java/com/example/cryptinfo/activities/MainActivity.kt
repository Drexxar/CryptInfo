package com.example.cryptinfo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.cryptinfo.R
import com.example.cryptinfo.fragments.CurrenciesListFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd

class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adInit()

        //вызов фрагмента
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, CurrenciesListFragment(),null)
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
                R.id.action_about ->{
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                    return true
                }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //добавляем межстраничную рекламу при выходе из приложения с помощью кнопки "назад"
        showAd()
    }

    //Функция загрузки межстраничной рекламы
    private fun showAd(){
        if(mInterstitialAd.isLoaded){
            mInterstitialAd.show()
        }
    }

    //Метод инициализации межстраничного баннера
    private fun adInit(){
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-9365306135013346/5748576584"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

    }

}