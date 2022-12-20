package com.murat.a3_mvppatterncount.presenter

import com.murat.a3_mvppatterncount.model.Counter
import com.murat.a3_mvppatterncount.view.CounterView

class Presenter {
    private val model  = Counter()
    lateinit var view : CounterView

    fun increment(){
        model.increment()
       view.changeCount(model.count)
        setCount(model.count)
    }

    fun decrement(){
        model.decrement()
        view.changeCount(model.count)
        setCount(model.count)
    }
    fun attachView(view : CounterView){
        this.view = view
    }

    private fun setCount(count : Int){
        if(count == 10){
             view.showMessage("Поздравляем")
        }
        if (count >= 15){
            view.changeColor(true)
        }else{
            view.changeColor(false)
        }

    }

}