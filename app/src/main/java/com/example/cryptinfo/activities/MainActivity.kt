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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

}