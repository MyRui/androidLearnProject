package com.max.loan.wanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.max.loan.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        GlobalScope.launch {  }

    }
}