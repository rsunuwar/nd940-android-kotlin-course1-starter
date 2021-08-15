package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String,
    var size: List<Double> = mutableListOf(),
    var company: String,
    var price: Double,
    var description: String,
    val images: Int
) : Parcelable
