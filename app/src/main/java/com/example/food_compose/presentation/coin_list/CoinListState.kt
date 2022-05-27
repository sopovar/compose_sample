package com.example.food_compose.presentation.coin_list

import com.example.food_compose.domain.model.Coin

/**
 * Created by Sopo Vardidze on 20.12.21
 */
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
