package com.murat.a3_mvppatterncount.view

interface CounterView {
    fun changeCount(count :Int)
    fun showMessage(message : String)
    fun changeColor(isRead : Boolean)
}