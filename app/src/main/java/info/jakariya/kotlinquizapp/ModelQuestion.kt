package info.jakariya.kotlinquizapp

class ModelQuestion (ques : String, opt1 :String, opt2 :String, opt3 :String, opt4 :String, ans :String, selectedAns: String = "") {

    lateinit var mQues :String
    lateinit var mOpt1 :String
    lateinit var mOpt2 :String
    lateinit var mOpt3 :String
    lateinit var mOpt4 :String
    lateinit var mAns :String
    lateinit var mUserSelectedAns :String

    init {
        mQues = ques
        mOpt1 = opt1
        mOpt2 = opt2
        mOpt3 = opt3
        mOpt4 = opt4
        mAns = ans
        mUserSelectedAns = selectedAns
    }

}