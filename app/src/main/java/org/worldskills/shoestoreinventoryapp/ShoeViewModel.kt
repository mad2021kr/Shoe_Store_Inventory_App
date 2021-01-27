package org.worldskills.shoestoreinventoryapp

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import java.lang.StringBuilder

class ShoeViewModel: ViewModel() {
    private var shoeDataList = ArrayList<ShoeDetail>()
    var shoeMutableList = MutableLiveData<MutableList<ShoeDetail>>()

    init {
        resetShoeList()
    }

    fun addShoeData(name: String, company: String, size: String, description: String) {
        shoeDataList.add(ShoeDetail(name, company, size, description))
        shoeMutableList.value = shoeDataList
    }

    private fun resetShoeList() {
        shoeDataList = arrayListOf(
            ShoeDetail("Pop", "Nike", "280", "Just Shoes"),
            ShoeDetail("For", "Adidas", "260", "Simple 3Line")
        )

        shoeMutableList.value = shoeDataList
    }
}