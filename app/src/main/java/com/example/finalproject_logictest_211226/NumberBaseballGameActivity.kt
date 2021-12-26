package com.example.finalproject_logictest_211226

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject_logictest_211226.adapters.ChatAdapter
import com.example.finalproject_logictest_211226.databinding.ActivityNumberBaseballGameBinding
import com.example.finalproject_logictest_211226.datas.ChatData

class NumberBaseballGameActivity : BaseActivity() {

    lateinit var binding : ActivityNumberBaseballGameBinding

    val mChatList = ArrayList<ChatData>()

    lateinit var mAdapter : ChatAdapter

//    컴퓨터가 낸 3자리 문제를 담아둘 ArrayList
    val cpuNumbers = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_number_baseball_game)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.btnSand.setOnClickListener {

            val inputMessage = binding.edtNumber.text.toString()

//            내가 입력한 내용으로 채팅 화면에 추가

            val myChatData = ChatData("USER",inputMessage)

            mChatList.add(myChatData)

//            어댑터에게 새로고침 처리
            mAdapter.notifyDataSetChanged()

//            숫자 입력칸 비워주기
            binding.edtNumber.setText("")

        }

    }

    override fun setValues() {

        makeCpuNumbers()

        mChatList.add(ChatData("CPU","숫자 야구게임에 오신것을 환영합니다."))
        mChatList.add(ChatData("CPU","3자리 숫자로 문제가 생성되었습니다."))
        mChatList.add(ChatData("CPU","밑의 입력칸을 이용해 3자리 숫자를 맞춰주세요."))

        mAdapter = ChatAdapter(mContext,mChatList)
        binding.chattingRecyclerView.adapter = mAdapter
        binding.chattingRecyclerView.layoutManager = LinearLayoutManager(mContext)

    }

//    컴퓨터가 3자리 문제 출제 함수

    fun makeCpuNumbers(){

//        3개의 숫자를 문제로 제출
        for ( i in 0 until 3 ) {

//            써도 되는 숫자가 나올때까지 무한반복 > 랜덤숫자 추출
            while (true){

//                1~9의 랜덤값 추출
                val randomNum = (Math.random()*9+1 ).toInt()  // 1~9 사이의 랜덤값.

//                cpuNumber에 이미 나와있냐?
                val isDuplOk = !cpuNumbers.contains(randomNum)

                if(isDuplOk){
                    cpuNumbers.add(randomNum)
//                    무한반복 종료 > 다음숫자 뽑으러.
                    break
                }

            }

        }

//        문제 확인용 로그
        for ( num in cpuNumbers){
            Log.d("문제숫자",cpuNumbers.toString())
        }

    }

}