package com.example.carapp5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carapp5.data.CarItem

class MainActivity : AppCompatActivity() {
    companion object {
        private const val REQUEST_CODE_ADD_CAR = 1
        private const val REQUEST_CODE_EDIT_CAR = 2
    }

    private lateinit var carList: MutableList<CarItem>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carList = mutableListOf(
            CarItem("Toyota", "Camry", 30000),
            CarItem("Honda", "Accord", 28000),
            CarItem("Ford", "Mustang", 35000),
            CarItem("Toyota", "Corolla", 25000),
            CarItem("Honda", "Civic", 24000),
            CarItem("Ford", "Fusion", 32000)
            // Добавьте здесь остальные автомобили
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CarAdapter(carList)
        recyclerView.adapter = adapter
    }

    fun addCar(view: View) {
        val intent = Intent(this, AddCarActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE_ADD_CAR)
    }

    /*TODO:
    fun editCar(view: View) {
        recyclerView.getChildAdapterPosition(view.parent as View)
        val position = recyclerView.getChildAdapterPosition(view.parent as View)
        val car = carList[position]

        val intent = Intent(this, EditCarActivity::class.java)
        val manufacturer = car.manufacturer
        val model = car.model
        val price = car.price

        val bundle = Bundle()
        bundle.putString("manufacturer", manufacturer)
        bundle.putString("model", model)
        if (price != null) {
            bundle.putInt("price", price)
        }
        bundle.putInt("pos", position)
        startActivityForResult(intent, REQUEST_CODE_EDIT_CAR)
    }*/

    fun sortCar(view:View){
        carList.sortBy{it.price};
        adapter.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_ADD_CAR && resultCode == RESULT_OK) {
            val bundle = data?.getExtras() as Bundle
            val car = CarItem(bundle.getString("manufacturer"), bundle.getString("model"), bundle.getInt("price"))
            carList.add(car)
            adapter.notifyDataSetChanged()
        }

        if (requestCode == REQUEST_CODE_EDIT_CAR && resultCode == RESULT_OK) {
            val bundle = data?.getExtras() as Bundle
            val car = CarItem(bundle.getString("manufacturer"), bundle.getString("model"), bundle.getInt("price"))
            val pos = bundle.getInt("pos")
            carList[pos] = car
            adapter.notifyDataSetChanged()
        }
    }
}