package com.example.cryptinfo.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptinfo.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        adInit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        rate_button.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${applicationContext.packageName}")))
        }

        //инициализация баннера
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
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