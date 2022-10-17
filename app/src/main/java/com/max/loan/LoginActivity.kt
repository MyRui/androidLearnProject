package com.max.loan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.ac_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_login)

        close.setOnClickListener {
            finish()
        }
        _91.text = "+91"
        phoneView.hint = "Phone Number"
        otpView.hint = "Verification Code"
        sendOtp.text = "SEND OTP"
        sendOtp.setOnClickListener {

        }
        loginBtn.text = "SIGN IN"
        loginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}