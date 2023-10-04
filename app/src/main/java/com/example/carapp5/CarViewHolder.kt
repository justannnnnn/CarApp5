package com.example.carapp5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carapp5.data.CarItem


class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(car: CarItem) {
        itemView.findViewById<TextView>(R.id.manufacturerTextView).text = car.manufacturer
        itemView.findViewById<TextView>(R.id.modelTextView).text = car.model
        itemView.findViewById<TextView>(R.id.priceTextView).text = car.price.toString()

    }



}