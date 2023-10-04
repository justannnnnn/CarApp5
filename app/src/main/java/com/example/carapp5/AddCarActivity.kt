package com.example.carapp5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.carapp5.data.CarItem

class AddCarActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_car_activity)
    }

    fun saveCar(view: View) {
        val manufacturer = findViewById<EditText>(R.id.editTextManufacturer).text.toString() // Получите производителя автомобиля из пользовательского ввода
        val model = findViewById<EditText>(R.id.editTextModel).text.toString() // Получите название модели автомобиля из пользовательского ввода
        val price = findViewById<EditText>(R.id.editTextPrice).text.toString().toInt() // Получите цену автомобиля из пользовательского ввода

        val intent = Intent()
        val bundle = Bundle()
        bundle.putString("manufacturer", manufacturer)
        bundle.putString("model", model)
        bundle.putInt("price", price)
        intent.putExtras(bundle)
        setResult(RESULT_OK, intent)
        finish()
    }
}