package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var price: Double,
    var description: String,
    val image: Int
) : Parcelable
