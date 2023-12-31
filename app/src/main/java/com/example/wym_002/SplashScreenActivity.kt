package com.example.wym_002

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wym_002.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashScreenBinding
    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        hidingPanel(window)

        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        // resultCardBalance        key: R.drawable.credit_card_white.toString()
        // resultWalletBalance      key: R.drawable.wallet_white.toString()
        // resultBankBalance        key: R.drawable.account_balance_white.toString()
        //
        // checkSplashScreen        key: getString(R.string.flagSplashScreen)      ОБРАТНЫЕ ПЕРЕМЕННЫЕ
        //                                                                        0 == TRUE   1 == FALSE
        // setDateDay               key: getString(R.string.setDateDay)

        binding.layoutWym.alpha = 0f

        when (pref.getInt(getString(R.string.flagSplashScreen), 0)){
            0 -> {
                binding.layoutWym.animate().setDuration(1000).alpha(1f).withEndAction {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    finish()
                }
            }
            else -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

    }
}