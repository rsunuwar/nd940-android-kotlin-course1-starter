package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R

class ShoeListViewModel: ViewModel() {

    private var _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val shoeSizes = listOf(5.5, 6.0, 6.5, 7.0, 7.5, 8.0, 9.0, 11.0)

    val allShoes = listOf(
        Shoe("Chuck Taylor", shoeSizes, "Converse", 59.99,"Ankle length Chuck Taylor Converse shoes.", R.drawable.chucktaylor),
        Shoe("Air Force", shoeSizes, "Nike",90.0, "The original Nike Air Force One.", R.drawable.airforce1),
        Shoe("Stan Smith", shoeSizes, "Adidas", 50.0, "The bestselling Stan Smith shoes.", R.drawable.stansmith),
        Shoe("All Star", shoeSizes, "Converse", 65.0, "The original all stars shoes.", R.drawable.allstar),
        Shoe("Boots", shoeSizes, "Dr. Martens", 180.0, "Dr. Martens chunky heeled boots.", R.drawable.drmartens),
        Shoe("BirkenStock Sandals", shoeSizes, "BirkenStock", 125.0, "Very comfortable, any occasion sandals.", R.drawable.birkenstock),
        Shoe("Strappy Sandals", shoeSizes, "Steve Madden", 68.50, "Preppy Strappy block heel sandals.", R.drawable.strappysandals),
        Shoe("Black Heels", shoeSizes, "Sam Edelman", 120.0, "Evening wear must have black heels.", R.drawable.blackheels),
        Shoe("Chelsea Boots", shoeSizes, "& Other Stories", 180.0, "Your daily regular boots.", R.drawable.chelseaboots),
        Shoe("Knee High Boots", shoeSizes, "ASOS", 50.0, "Best boots for winter. Knee high length.", R.drawable.kneehighboots)
    )

    init {
        _shoeList.value = allShoes
    }

}
