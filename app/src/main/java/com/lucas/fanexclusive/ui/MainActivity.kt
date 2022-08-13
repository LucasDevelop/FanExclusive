package com.lucas.fanexclusive.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucas.fanexclusive.R

/**
 * @date 2022/6/2
 * @author lucas
 * @des
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onBackPressed() {
        //不允许返回
//        super.onBackPressed()
    }
}