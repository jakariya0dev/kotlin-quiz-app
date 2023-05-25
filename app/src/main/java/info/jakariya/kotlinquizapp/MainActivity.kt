package info.jakariya.kotlinquizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val questions = listOf(
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
        ),
        ModelQuestion(
            "বঙ্গবন্ধু শেখ মুজিবুর রহমান রচিত গ্রন্থ কোনটি?",
            "সত্য মামলা আগরতলা",
            "অবরুদ্ধ নয় মাস",
            "অসমাপ্ত আত্মজীবনী",
            "বাংলাদেশ কথা কয়",
            "c"
        ),
        ModelQuestion(
            "কোন পত্রিকা শেখ মুজিবুর রহমানকে রাজনীতির কবি উপাধি দিয়েছিলো ",
            "নিউজ উইকস",
            "দি ইকনমিস্ট",
            "টাইম",
            "গার্ডিয়ান",
            "a"
        ),
    )

    private var index = 0
    private var rightAns = 0
    private var isOptSelected = false

    private lateinit var rlOpt1 :RelativeLayout
    private lateinit var rlOpt2 :RelativeLayout
    private lateinit var rlOpt3 :RelativeLayout
    private lateinit var rlOpt4 :RelativeLayout

    private lateinit var tvQues :TextView
    private lateinit var tvOpt1 :TextView
    private lateinit var tvOpt2 :TextView
    private lateinit var tvOpt3 :TextView
    private lateinit var tvOpt4 :TextView

    private lateinit var ivOpt1 :ImageView
    private lateinit var ivOpt2 :ImageView
    private lateinit var ivOpt3 :ImageView
    private lateinit var ivOpt4 :ImageView

    private lateinit var btnNext :Button
    private lateinit var tvQuesNo :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Code for Alert Dialog

        val builder = AlertDialog.Builder(this)
        val resultView = LayoutInflater.from(this).inflate(R.layout.result_layout, null)
        builder.setView(resultView)
        builder.setCancelable(false)
        val tvTotalQuestion = resultView.findViewById<TextView>(R.id.tv_total_questions_id)
        val tvRightAns = resultView.findViewById<TextView>(R.id.tv_right_ans_id)
        val btnClose = resultView.findViewById<Button>(R.id.btn_close_id)
        val alertDialog = builder.create()


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
            isOptSelected = true
            questions[index].mUserSelectedAns = "a"
        }
        rlOpt2.setOnClickListener {
            ivOpt1.visibility = View.INVISIBLE
            ivOpt2.visibility = View.VISIBLE
            ivOpt3.visibility = View.INVISIBLE
            ivOpt4.visibility = View.INVISIBLE
            isOptSelected = true
            questions[index].mUserSelectedAns = "b"
        }
        rlOpt3.setOnClickListener {
            ivOpt1.visibility = View.INVISIBLE
            ivOpt2.visibility = View.INVISIBLE
            ivOpt3.visibility = View.VISIBLE
            ivOpt4.visibility = View.INVISIBLE
            isOptSelected = true
            questions[index].mUserSelectedAns = "c"
        }
        rlOpt4.setOnClickListener {
            ivOpt1.visibility = View.INVISIBLE
            ivOpt2.visibility = View.INVISIBLE
            ivOpt3.visibility = View.INVISIBLE
            ivOpt4.visibility = View.VISIBLE
            isOptSelected = true
            questions[index].mUserSelectedAns = "d"
        }

        btnNext.setOnClickListener {
            if (!isOptSelected){
                val sb = Snackbar.make(it, "Please Select an option!", Snackbar.LENGTH_LONG)
                sb.setAction("Ok", View.OnClickListener {
                    sb.dismiss()
                })
                sb.show()
            }
            else if(index <questions.size-1) {
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
                isOptSelected = false
                if (index == questions.size-1) btnNext.text = "Submit"
            }
            else{
                questions.forEach {
//                    Log.d("ans", it.mUserSelectedAns)
                    if (it.mAns == it.mUserSelectedAns) rightAns++

                }

                tvTotalQuestion.text = "Total Questions: " + questions.size.toString()
                tvRightAns.text = "Right Answer: " + rightAns.toString()
                alertDialog.show()
            }

        }

        btnClose.setOnClickListener {
            alertDialog.dismiss()
            finish()
            startActivity(intent)

        }

    }
}