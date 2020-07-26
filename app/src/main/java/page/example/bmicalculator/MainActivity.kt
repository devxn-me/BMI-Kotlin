package page.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()

    }

    private fun initListeners() {
        calculate_btn_male.setOnClickListener{
            onClick()
        }
        calculate_btn_female.setOnClickListener{
            onClick()
        }
    }

    private fun onClick() {
        val weight = weight_et.text.toString().toFloat()
        val height = height_et.text.toString().toFloat()
        val bmi = calculate(weight, height)
        val result = interpretate(bmi)
        result_tv.text = result
        score_tv.text = "%.1f".format(bmi)
    }

    private fun calculate(weight: Float, height: Float) = weight / ((height / 100) * (height / 100))

    private fun interpretate(BMI: Float): String {
        val diagnostic = when (BMI) {
            in 0f..16f -> "Thinness.Let's eat more healthy food today!."
            in 16f..17f -> "Thinness.Let's eat more healthy food today!."
            in 17f..18.5f -> "Thinness.Let's eat more healthy food today!."
            in 18.5f..25f -> "AWESOME! YOU HAVE A GREAT SHAPE!"
            in 25f..30f -> "OVERWEIGHT. YOU NEED A WORKOUT!"
            in 30f..35f -> "Overweight. You need workout! "
            in 35f..40f -> "Overweight. You need workout!"
            else -> "Overweight. You need workout!"
        }

        return diagnostic
    }
}
