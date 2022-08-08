package com.pptg.emeasure.bean
import androidx.room.ColumnInfo

data class DashboardBean(
    val name:String,
    val disp:String,
    @ColumnInfo(name = "createTime")
    val time:String,
    val taskID:String,
    val historyID:Int,
    val status: String
)