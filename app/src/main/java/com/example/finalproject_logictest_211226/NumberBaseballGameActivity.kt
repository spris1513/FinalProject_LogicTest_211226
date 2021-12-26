package com.example.finalproject_logictest_211226

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject_logictest_211226.adapters.ChatAdapter
import com.example.finalproject_logictest_211226.databinding.ActivityNumberBaseballGameBinding
import com.example.finalproject_logictest_211226.datas.ChatData

class NumberBaseballGameActivity : BaseActivity() {

    lateinit var binding : ActivityNumberBaseballGameBinding

    val mChatList = ArrayList<ChatData>()

    lateinit var mAdapter : ChatAdapter

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

        mChatList.add(ChatData("CPU","숫자 야구게임에 오신것을 환영합니다."))
        mChatList.add(ChatData("CPU","3자리 숫자로 문제가 생성되었습니다."))
        mChatList.add(ChatData("CPU","밑의 입력칸을 이용해 3자리 숫자를 맞춰주세요."))

        mAdapter = ChatAdapter(mContext,mChatList)
        binding.chattingRecyclerView.adapter = mAdapter
        binding.chattingRecyclerView.layoutManager = LinearLayoutManager(mContext)

    }
}