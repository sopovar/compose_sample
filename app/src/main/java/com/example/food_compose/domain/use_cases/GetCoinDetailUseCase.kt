package com.example.food_compose.domain.use_cases

import com.example.food_compose.common.Resource
import com.example.food_compose.data.dto.toCoin
import com.example.food_compose.data.dto.toCoinDetail
import com.example.food_compose.domain.model.CoindDetail
import com.example.food_compose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Sopo Vardidze on 13.12.21
 */
class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoindDetail>> = flow {
        try {
            emit(Resource.Loading<CoindDetail>())
            val coinDetail = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoindDetail>(coinDetail))
        } catch (ex: HttpException) {
            emit(Resource.Error<CoindDetail>(ex.localizedMessage ?: "An unexpected error occured"))
        } catch (io: IOException) {
            emit(Resource.Error<CoindDetail>(io.localizedMessage ?: "Some unknown error"))
        }
    }
}