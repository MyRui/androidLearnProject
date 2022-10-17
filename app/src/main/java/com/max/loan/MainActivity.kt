package com.max.loan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.max.loan.animate.PropertyAnimateActivity
import com.max.loan.animate.ViewAnimateActivity
import com.max.loan.simulateNetEaseCloudMusic.ui.RippleActivity
import com.max.loan.wanandroid.ArticleActivity
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
            startActivity(Intent(this, ArticleActivity::class.java))
        }
    }

}