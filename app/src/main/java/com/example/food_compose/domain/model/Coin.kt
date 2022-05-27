package com.example.food_compose.domain.model

/**
 * Created by Sopo Vardidze on 13.12.21
 */
data class Coin(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)
