package com.example.democlass.data.post


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Modify(
    @SerialName("href")
    val href: String
)