package com.example.food_compose.data.repository

import com.example.food_compose.data.dto.CoinDetailDto
import com.example.food_compose.data.dto.CoinDto
import com.example.food_compose.data.remote.CoinPaprikaApi
import com.example.food_compose.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * Created by Sopo Vardidze on 13.12.21
 */
class CoinRepositoryImpl @Inject constructor(
  private val paprikaApi: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoinList(): List<CoinDto> {
        return paprikaApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return paprikaApi.getCoinDetail(coinId)
    }
}