package com.example.carapp5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EditCarActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_car_activity)
        val bundle = intent.getExtras() as Bundle
        findViewById<EditText>(R.id.editTextManufacturer).setText(bundle.getString("manufacturer"))
        findViewById<EditText>(R.id.editTextModel).setText(bundle.getString("model"))
        findViewById<EditText>(R.id.editTextPrice).setText(bundle.getInt("price"))

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
        bundle.putInt("pos", (intent.getExtras() as Bundle).getInt("pos"))
        intent.putExtras(bundle)
        setResult(RESULT_OK, intent)
        finish()
    }
}
