package com.example.carapp5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carapp5.data.CarItem



class CarAdapter(private val cList: List<CarItem>) : RecyclerView.Adapter<CarViewHolder>() {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.car_item, parent, false)

        return CarViewHolder(view)
    }



    // binds the list items to a view
    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {

        val CarItem = cList[position]

        // sets the image to the imageview from our itemHolder class
        holder.bind(CarItem)

    }

    // return the number of the items in the list
    override fun getItemCount() = cList.size



}