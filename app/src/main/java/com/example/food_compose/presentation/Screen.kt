package com.example.food_compose.presentation

/**
 * Created by Sopo Vardidze on 20.12.21
 */
sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
}