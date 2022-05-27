package com.example.food_compose.data.remote

import com.example.food_compose.data.dto.CoinDetailDto
import com.example.food_compose.data.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Sopo Vardidze on 13.12.21
 */
interface CoinPaprikaApi {

    @GET("v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coindId}")
    suspend fun getCoinDetail(@Path("coindId") coinId: String): CoinDetailDto

}