package com.example.food_compose.domain.repository

import com.example.food_compose.data.dto.CoinDetailDto
import com.example.food_compose.data.dto.CoinDto

/**
 * Created by Sopo Vardidze on 13.12.21
 */
interface CoinRepository {

    suspend fun getCoinList(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}