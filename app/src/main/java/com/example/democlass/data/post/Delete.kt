package com.example.democlass.data.post


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Delete(
    @SerialName("href")
    val href: String
)