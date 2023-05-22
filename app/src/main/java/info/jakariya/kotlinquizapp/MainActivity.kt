package info.jakariya.kotlinquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val questions = listOf<ModelQuestion>(
        ModelQuestion(
            "বঙ্গবন্ধু শেখ মুজিবুর রহমান পাকিস্তানের কারাগার থেকে মুক্তি পান কতো তারিখে?",
            "৯ জানুয়ারী ১৯৭২",
            "১৬ ডিসেম্বর ১৯৭২",
            "৮ জানুয়ারি ১৯৭২ ",
            "১০ জানুয়ারি ১৯৭২",
            "c"
        ),
        ModelQuestion(
            "বঙ্গবন্ধু শেখ মুজিবুর রহমান কত তারিখে জন্মগ্রহণ করেন?",
            "১ মার্চ ১৯১৯ খৃঃ",
            "১৭ মার্চ ১৯২০ খৃঃ",
            "১৪ আগস্ট ১৯৪৭ খৃঃ",
            "২১ জুন ১৯৪১ খৃঃ",
            "b"
        ),
        ModelQuestion(
            "শেখ মুজিবুর রহমানকে মোট কত বছর কারাগারে কাটাতে হয়েছে?",
            "১২ বছর",
            "১৪ বছর",
            "১০ বছর",
            "৮ বছর",
            "a"
        )
    )

    var index = 0

    lateinit var rlOpt1 :RelativeLayout
    lateinit var rlOpt2 :RelativeLayout
    lateinit var rlOpt3 :RelativeLayout
    lateinit var rlOpt4 :RelativeLayout

    lateinit var tvQues :TextView
    lateinit var tvOpt1 :TextView
    lateinit var tvOpt2 :TextView
    lateinit var tvOpt3 :TextView
    lateinit var tvOpt4 :TextView

    lateinit var ivOpt1 :ImageView
    lateinit var ivOpt2 :ImageView
    lateinit var ivOpt3 :ImageView
    lateinit var ivOpt4 :ImageView

    lateinit var btnNext :Button
    lateinit var tvQuesNo :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rlOpt1 = findViewById(R.id.rl_o1_id)
        rlOpt2 = findViewById(R.id.rl_o2_id)
        rlOpt3 = findViewById(R.id.rl_o3_id)
        rlOpt4 = findViewById(R.id.rl_o4_id)

        tvQues = findViewById(R.id.tv_ques_id)
        tvOpt1 = findViewById(R.id.tv_o1_id)
        tvOpt2 = findViewById(R.id.tv_o2_id)
        tvOpt3 = findViewById(R.id.tv_o3_id)
        tvOpt4 = findViewById(R.id.tv_o4_id)

        ivOpt1 = findViewById(R.id.iv_o1_id)
        ivOpt2 = findViewById(R.id.iv_o2_id)
        ivOpt3 = findViewById(R.id.iv_o3_id)
        ivOpt4 = findViewById(R.id.iv_o4_id)

        btnNext = findViewById(R.id.btn_next_id)
        tvQuesNo = findViewById(R.id.tv_ques_no_id)

        tvQues.text = questions[index].mQues
        tvOpt1.text = questions[index].mOpt1
        tvOpt2.text = questions[index].mOpt2
        tvOpt3.text = questions[index].mOpt3
        tvOpt4.text = questions[index].mOpt4
        tvQuesNo.text = "${index + 1}/${questions.size}"

        rlOpt1.setOnClickListener {
            ivOpt1.visibility = View.VISIBLE
            ivOpt2.visibility = View.INVISIBLE
            ivOpt3.visibility = View.INVISIBLE
            ivOpt4.visibility = View.INVISIBLE

            questions[index].mUserSelectedAns = "a"
        }
        rlOpt2.setOnClickListener {
            ivOpt1.visibility = View.INVISIBLE
            ivOpt2.visibility = View.VISIBLE
            ivOpt3.visibility = View.INVISIBLE
            ivOpt4.visibility = View.INVISIBLE
            questions[index].mUserSelectedAns = "b"
        }
        rlOpt3.setOnClickListener {
            ivOpt1.visibility = View.INVISIBLE
            ivOpt2.visibility = View.INVISIBLE
            ivOpt3.visibility = View.VISIBLE
            ivOpt4.visibility = View.INVISIBLE
            questions[index].mUserSelectedAns = "c"
        }
        rlOpt4.setOnClickListener {
            ivOpt1.visibility = View.INVISIBLE
            ivOpt2.visibility = View.INVISIBLE
            ivOpt3.visibility = View.INVISIBLE
            ivOpt4.visibility = View.VISIBLE
            questions[index].mUserSelectedAns = "d"
        }

        btnNext.setOnClickListener {
            if(index <questions.size-1) {
                index++
                ivOpt1.visibility = View.INVISIBLE
                ivOpt2.visibility = View.INVISIBLE
                ivOpt3.visibility = View.INVISIBLE
                ivOpt4.visibility = View.INVISIBLE
                tvQues.text = questions[index].mQues
                tvOpt1.text = questions[index].mOpt1
                tvOpt2.text = questions[index].mOpt2
                tvOpt3.text = questions[index].mOpt3
                tvOpt4.text = questions[index].mOpt4
                tvQuesNo.text = "${index + 1}/${questions.size}"
                if (index == questions.size-1) btnNext.text = "Submit"
            }
            else{
                questions.forEach {
                    Log.d("ans", it.mUserSelectedAns)
                }
            }

        }

    }
}