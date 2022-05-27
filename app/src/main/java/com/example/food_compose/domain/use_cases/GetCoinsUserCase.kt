package com.example.food_compose.domain.use_cases

import com.example.food_compose.common.Resource
import com.example.food_compose.data.dto.toCoin
import com.example.food_compose.domain.model.Coin
import com.example.food_compose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Sopo Vardidze on 13.12.21
 */
class GetCoinsUserCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoinList().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (ex: HttpException) {
            emit(Resource.Error<List<Coin>>(ex.localizedMessage ?: "An unexpected error occured"))
        } catch (io: IOException) {
            emit(Resource.Error<List<Coin>>(io.localizedMessage ?: "Some unknown error"))
        }
    }
}