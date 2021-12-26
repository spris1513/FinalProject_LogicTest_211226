package com.example.finalproject_logictest_211226

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.finalproject_logictest_211226.databinding.ActivityLottoSimulatorBinding

class LottoSimulatorActivity : BaseActivity() {

    lateinit var binding: ActivityLottoSimulatorBinding

    //    내 입력 번호 목록
    val myNumberList = arrayListOf(5, 10, 12, 15, 16, 24)

    //    랜덤 당첨번호 목록 > 나중에 6개를 채워야 함.
    val winNumBerList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lotto_simulator)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.btnBuyLotto.setOnClickListener {

//            당첨번호 만들기 기능 실행
            makeWinNumbers()

        }

    }

    fun makeWinNumbers() {

//        6번 반복 > 당첨번호 6개 생성
        for (i in 0 until 6) {

//            밑의 3가지 프로세스는 > 제대로 된 숫자가 나올대까지 무한 반복.
//            while > if와 문법이 동일한 수준임.

            while (true) {

//            1. 1~45 의 랜덤값 > Math.random()
//                > 0 * 45 <= 랜덤값 * 45 +1 < 1 * 45 (실수)

                val randomNum = (Math.random()*45 + 1).toInt()  // 실수 > 정수로 변환 : 소수점자리는 버림 처리

//            2. 나온 랜덤값이 중복인가?
//            3. 중복이 아니면(써도 된다면) winNumberList에 등록(추가)
//                > 다음 숫자를 뽑으러 넘어가자
//                > while 무한반복 강제종료 > for문에 의해서 다음 숫자를 뽑으러 이동


            }


        }

    }

    override fun setValues() {

    }
}