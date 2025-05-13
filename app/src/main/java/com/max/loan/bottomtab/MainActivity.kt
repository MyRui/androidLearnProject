package com.max.loan.bottomtab

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.max.loan.R

class MainActivityTestBoyyom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_test_bottom_tab)

        val resouceList = arrayOf(R.drawable.p_1, R.drawable.p_2, R.drawable.p_3, R.drawable.p_4, R.drawable.p_5)
//        val resouceList = arrayOf(R.drawable.p_1, R.drawable.p_2, R.drawable.p_3)
        val list = ArrayList<ImageView>()
        for (i in 0..2) {
            val iv = ImageView(this)
            iv.setImageResource(resouceList[i])
            iv.layoutParams = ViewGroup.LayoutParams(dp2Px(this, 40.0f), dp2Px(this, 40.0f))
            list.add(iv)
        }
        findViewById<NavigationBarView>(R.id.navigationBarView).addImageButtons(list)

    }
}
