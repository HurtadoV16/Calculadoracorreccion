package com.example.calculadorav
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadorav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tvResult: TextView
    private var currentNumber: String = ""
    private var currentOperator: String = ""
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tvResult = findViewById(R.id.tvResult)

        val btnClear: Button = findViewById(R.id.btnClear)
        btnClear.setOnClickListener(this)

        val btnDivide: Button = findViewById(R.id.btnDivide)
        btnDivide.setOnClickListener(this)

        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        btnMultiply.setOnClickListener(this)

        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        btnSubtract.setOnClickListener(this)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener(this)

        val btnEquals: Button = findViewById(R.id.btnEquals)
        btnEquals.setOnClickListener(this)

        val btn0: Button = findViewById(R.id.btn0)
        btn0.setOnClickListener(this)

        val btn1: Button = findViewById(R.id.btn1)
        btn1.setOnClickListener(this)

        val btn2: Button = findViewById(R.id.btn2)
        btn2.setOnClickListener(this)

        val btn3: Button = findViewById(R.id.btn3)
        btn3.setOnClickListener(this)

        val btn4: Button = findViewById(R.id.btn4)
        btn4.setOnClickListener(this)

        val btn5: Button = findViewById(R.id.btn5)
        btn5.setOnClickListener(this)

        val btn6: Button = findViewById(R.id.btn6)
        btn6.setOnClickListener(this)

        val btn7: Button = findViewById(R.id.btn7)
        btn7.setOnClickListener(this)

        val btn8: Button = findViewById(R.id.btn8)
        btn8.setOnClickListener(this)

        val btn9: Button = findViewById(R.id.btn9)
        btn9.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnClear -> {
                clearResult()
            }
            R.id.btnDivide -> {
                setOperator("/")
            }
            R.id.btnMultiply -> {
                setOperator("*")
            }
            R.id.btnSubtract -> {
                setOperator("-")
            }
            R.id.btnAdd -> {
                setOperator("+")
            }
            R.id.btnEquals -> {
                calculateResult()
            }
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 -> {
                appendNumber((view as Button).text.toString())
            }
        }
    }

    private fun appendNumber(number: String) {
        currentNumber += number
        tvResult.text = currentNumber
    }

    private fun setOperator(operator: String) {
        if (currentNumber.isNotEmpty()) {
            operand1 = currentNumber.toDouble()
            currentNumber = ""
            currentOperator = operator
        }
    }

    private fun calculateResult() {
        if (currentNumber.isNotEmpty()) {
            operand2 = currentNumber.toDouble()
            currentNumber = ""
        }

        when (currentOperator) {
            "+" -> {
                val result = operand1 + operand2
                tvResult.text = result.toString()
            }
            "-" -> {
                val result = operand1 - operand2
                tvResult.text = result.toString()
            }
            "*" -> {
                val result = operand1 * operand2
                tvResult.text = result.toString()
            }
            "/" -> {
                if (operand2 != 0.0) {
                    val result = operand1 / operand2
                    tvResult.text = result.toString()
                } else {
                    tvResult.text = "Error"
                }
            }
        }
    }

    private fun clearResult() {
        currentNumber = ""
        operand1 = 0.0
        operand2 = 0.0
        currentOperator = ""
        tvResult.text = ""
    }
}