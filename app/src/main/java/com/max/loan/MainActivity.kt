package com.max.loan

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.max.loan.animate.PropertyAnimateActivity
import com.max.loan.animate.ViewAnimateActivity
import com.max.loan.simulateNetEaseCloudMusic.ui.RippleActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rippleActivityBtn.setOnClickListener {
            startActivity(Intent(this, RippleActivity::class.java))
        }

        viewAnimateBtn.setOnClickListener {
            startActivity(Intent(this, ViewAnimateActivity::class.java))
        }

        propertyAnimateBtn.setOnClickListener {
            startActivity(Intent(this, PropertyAnimateActivity::class.java))
        }

        articleList.setOnClickListener {
            ussd()
//            goCallPhone(this,"*878#")
//            goCallPhone(this, "*878%23")
//            startActivity(Intent(this, ArticleActivity::class.java))
        }
    }

    private fun ussd() {
        val ussdCallback = @RequiresApi(Build.VERSION_CODES.O)
        object : TelephonyManager.UssdResponseCallback() {
            override fun onReceiveUssdResponse(
                telephonyManager: TelephonyManager?,
                request: String?,
                response: CharSequence?
            ) {
                Log.d("TAG", "onReceiveUssdResponse,request: $request , response: $response")
            }

            override fun onReceiveUssdResponseFailed(
                telephonyManager: TelephonyManager?,
                request: String?,
                failureCode: Int
            ) {
                Log.d(
                    "TAG",
                    "onReceiveUssdResponseFailed,request: $request , failureCode: $failureCode"
                )
            }

        }

        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        telephonyManager.sendUssdRequest(
            "*878#",
            ussdCallback, Handler()
        )
    }

    override fun onResume() {
        super.onResume()
//        if (!isAccessibilitySettingsOn(MyService::class.java)) {
//            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
//        } else {
////            "com.myvodafoneapp"
//        }
    }

}