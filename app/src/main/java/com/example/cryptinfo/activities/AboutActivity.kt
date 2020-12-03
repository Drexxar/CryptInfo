package com.example.cryptinfo.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptinfo.R
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        rate_button.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${applicationContext.packageName}")))
        }

        //инициализация баннера
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }
}