package org.worldskills.shoestoreinventoryapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.StringBuilder

class ShoeViewModel: ViewModel() {
    private var shoeDataList = ArrayList<ShoeDetail>()
    var shoeMutableList = MutableLiveData<MutableList<ShoeDetail>>()

    init {
        resetShoeList()
    }

    fun addShoeData(detail: ShoeDetail) {
        shoeDataList.add(detail)
        shoeMutableList.value = shoeDataList
    }

    private fun resetShoeList() {
        shoeDataList = arrayListOf(
            ShoeDetail("Pop", "Nike", 280, "Just Shoes"),
            ShoeDetail("For", "Adidas", 260, "Simple 3Line")
        )

        shoeMutableList.value = shoeDataList
    }
}