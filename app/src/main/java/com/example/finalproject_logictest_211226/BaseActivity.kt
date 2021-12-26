package com.example.finalproject_logictest_211226

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//상속 허용 방법 > 1. open Class 사용 2. abstract Class 사용

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this
    }

    abstract fun setupEvents()
    abstract fun setValues()


}