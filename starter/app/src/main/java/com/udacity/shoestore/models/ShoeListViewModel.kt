package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R

class ShoeListViewModel: ViewModel() {

    private var _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val allShoes = listOf(
        Shoe("Chuck Taylor", 5.5, "Converse", 59.99,"Ankle length Chuck Taylor Converse shoes.", R.drawable.chucktaylor),
        Shoe("Air Force", 6.0, "Nike",90.0, "The original Nike Air Force One.", R.drawable.airforce1),
        Shoe("Stan Smith", 7.5, "Adidas", 50.0, "The bestselling Stan Smith shoes.", R.drawable.stansmith),
        Shoe("All Star", 7.0, "Converse", 65.0, "The original all stars shoes.", R.drawable.allstar),
        Shoe("Boots", 11.0, "Dr. Martens", 180.0, "Dr. Martens chunky heeled boots.", R.drawable.drmartens),
        Shoe("BirkenStock Sandals", 5.0, "BirkenStock", 125.0, "Very comfortable, any occasion sandals.", R.drawable.birkenstock),
        Shoe("Strappy Sandals", 6.5, "Steve Madden", 68.50, "Preppy Strappy block heel sandals.", R.drawable.strappysandals),
        Shoe("Black Heels", 6.0, "Sam Edelman", 120.0, "Evening wear must have black heels.", R.drawable.blackheels),
        Shoe("Chelsea Boots", 8.5, "& Other Stories", 180.0, "Your daily regular boots.", R.drawable.chelseaboots),
        Shoe("Knee High Boots", 6.5, "ASOS", 50.0, "Best boots for winter. Knee high length.", R.drawable.kneehighboots)
    )

    init {
        _shoeList.value = allShoes
    }

}
