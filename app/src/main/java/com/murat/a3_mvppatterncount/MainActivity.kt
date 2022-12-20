package com.murat.a3_mvppatterncount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.murat.a3_mvppatterncount.databinding.ActivityMainBinding
import com.murat.a3_mvppatterncount.presenter.Presenter
import com.murat.a3_mvppatterncount.utils.showToast
import com.murat.a3_mvppatterncount.view.CounterView

class MainActivity : AppCompatActivity(),CounterView {

    var presenter = Presenter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)

        initClicker()

    }

    private fun initClicker() {

        with(binding){
            incrementBtn.setOnClickListener {
                presenter.increment()
            }

            decrementBtn.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun changeCount(count: Int) {
        binding.tvCounter.text = count.toString()
    }

    override fun showMessage(message: String) {
        showToast(message)
    }

    override fun changeColor(isRead: Boolean) {
       if (isRead){
           binding.tvCounter.setTextColor(resources.getColor(R.color.purple_200))
       }else{
           binding.tvCounter.setTextColor(resources.getColor(R.color.black))
       }
    }


}