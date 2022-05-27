package com.example.food_compose.presentation.coin_details

import com.example.food_compose.domain.model.CoindDetail

/**
 * Created by Sopo Vardidze on 20.12.21
 */
data class CoinDetailState(
    val isLoading: Boolean = false,
    val coins: CoindDetail? = null,
    val error: String = ""
)
