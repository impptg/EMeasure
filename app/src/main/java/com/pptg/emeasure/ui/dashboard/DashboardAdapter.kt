package com.pptg.emeasure.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pptg.emeasure.R
import com.pptg.emeasure.bean.DashboardBean
import com.pptg.emeasure.ui.EMApplication


class DashboardAdapter(var mList:List<DashboardBean>):
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dashboard, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mBean = mList[position]
        holder.apply {
            tv_name.text = mBean.name
            tv_disp.text = mBean.disp
            tv_time.text = mBean.time
            when(mBean.status){
                DashboardEnum.Status.TO_DO.toString() -> {
                    cv_status.setCardBackgroundColor(
                        EMApplication.context.getResources()
                        .getColor(R.color.status_1,null))
                    tv_status.text = "待测量"
                }
                DashboardEnum.Status.TO_SUBMIT.toString() -> {
                    cv_status.setCardBackgroundColor(EMApplication.context.getResources()
                        .getColor(R.color.status_2,null))
                    tv_status.text = "待提交"
                }
                DashboardEnum.Status.REVIEWING.toString() -> {
                    cv_status.setCardBackgroundColor(EMApplication.context.getResources()
                        .getColor(R.color.status_3,null))
                    tv_status.text = "审核中"
                }
                DashboardEnum.Status.MODIFY.toString() -> {
                    cv_status.setCardBackgroundColor(EMApplication.context.getResources()
                        .getColor(R.color.status_4,null))
                    tv_status.text = "请修改"
                }
                DashboardEnum.Status.FINISH.toString() -> {
                    cv_status.setCardBackgroundColor(EMApplication.context.getResources()
                        .getColor(R.color.status_5,null))
                    tv_status.text = "已完成"
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tv_name: TextView = view.findViewById(R.id.tv_item_dash_name)
        val tv_disp: TextView = view.findViewById(R.id.tv_item_dash_disp)
        val tv_time: TextView = view.findViewById(R.id.tv_item_dash_time)
        val tv_status: TextView = view.findViewById(R.id.tv_item_dash_status)
        val cv_status: CardView = view.findViewById(R.id.cv_item_dash_status)
    }
}