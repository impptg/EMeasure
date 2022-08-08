package com.pptg.emeasure.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pptg.emeasure.bean.DashboardBean
import com.pptg.emeasure.ui.EMApplication

class DashboardViewModel : ViewModel() {

    companion object{
        private const val TAG = "DashboardViewModel"
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    var mList1:MutableList<DashboardBean> = ArrayList<DashboardBean>()
    var mList2:MutableList<DashboardBean> = ArrayList<DashboardBean>()
    val text: LiveData<String> = _text
    val ss = "qaqqaq"

    var isChange : MutableLiveData<DashboardEnum.Change> = MutableLiveData(DashboardEnum.Change.Init)
    init {
        updateList()
    }

    fun changeState(){

    }

    fun updateList(){
//        isChange.postValue(DashboardEnum.Change.START)
//        mList1.clear()
//        mList2.clear()
//        val mTodo:List<DashboardBean> = EMApplication.dbManager.getHistoryDao().queryHistoryStr("TODO")
//        val mSubmit:List<DashboardBean> = EMApplication.dbManager.getHistoryDao().queryHistoryStr("TO_SUBMIT")
//        val mReviewing:List<DashboardBean> = EMApplication.dbManager.getHistoryDao().queryHistoryStr("REVIEWING")
//        val mStop:List<DashboardBean> = EMApplication.dbManager.getHistoryDao().queryHistoryStr("STOP")
//        val mModify:List<DashboardBean> = EMApplication.dbManager.getHistoryDao().queryHistoryStr("MODIFY")
//        val mFinish:List<DashboardBean> = EMApplication.dbManager.getHistoryDao().queryHistoryStr("FINISH")
//        for(i in mSubmit) mList1.add(i)
//        for(i in mModify) mList1.add(i)
//        for(i in mReviewing) mList2.add(i)
//        for(i in mStop) mList2.add(i)
//        for(i in mFinish) mList2.add(i)
//        isChange.postValue(DashboardEnum.Change.SUCCESS)
    }
}