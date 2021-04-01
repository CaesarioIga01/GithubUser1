package com.example.githubuser1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var photo: Int,
    var name: String,
    var location: String,
    var company: String,
    var username: String,
    var repository: String,
    var followers: Int,
    var following: Int
) :Parcelable