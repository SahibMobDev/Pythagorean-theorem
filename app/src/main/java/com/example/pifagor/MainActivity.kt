package com.example.pifagor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.VisibleForTesting
import com.example.pifagor.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun onClickResult(view:View){

        if (!isFieldEmpty()){
            val result = getString(R.string.result_info) + getResult()
            binding.tvResult.text = result
        }
    }

    private fun isFieldEmpty (): Boolean{

        binding.apply {
            if (edA.text.isNullOrEmpty()) edA.error = "ERROR"
            if (edB.text.isNullOrEmpty()) edB.error = "ERROR"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String{

        var a : Double
        var b : Double

        a = binding.edA.text.toString().toDouble()
        b = binding.edB.text.toString().toDouble()

        var result = a.pow(2) + b.pow(2)
        return result.toString()
    }

}