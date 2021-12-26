package com.example.finalproject_logictest_211226

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.finalproject_logictest_211226.databinding.ActivityLottoSimulatorBinding

class LottoSimulatorActivity : BaseActivity() {

    lateinit var binding : ActivityLottoSimulatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lotto_simulator)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}