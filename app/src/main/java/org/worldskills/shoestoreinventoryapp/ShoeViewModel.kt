package org.worldskills.shoestoreinventoryapp

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import java.lang.StringBuilder

class ShoeViewModel: ViewModel() {
    var shoeDetail: ShoeDetail = ShoeDetail("", "", "", "")
    private var shoeDataList = ArrayList<ShoeDetail>()
    var shoeMutableList = MutableLiveData<MutableList<ShoeDetail>>()

    init {
        resetShoeList()
    }

    fun addShoeData(shoeDetail: ShoeDetail) {
        shoeDataList.add(shoeDetail)
        shoeMutableList.value = shoeDataList
        this.shoeDetail = ShoeDetail("", "", "", "")
    }

    private fun resetShoeList() {
        shoeDataList = arrayListOf(
            ShoeDetail("Pop", "Nike", "280", "Just Shoes"),
            ShoeDetail("For", "Adidas", "260", "Simple 3Line")
        )

        shoeMutableList.value = shoeDataList
    }
}