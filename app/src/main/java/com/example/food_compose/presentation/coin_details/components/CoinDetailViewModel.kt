package com.example.food_compose.presentation.coin_details.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.food_compose.common.Constants.PARA_COIN_ID
import com.example.food_compose.common.Resource
import com.example.food_compose.domain.use_cases.GetCoinDetailUseCase
import com.example.food_compose.presentation.coin_details.CoinDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Sopo Vardidze on 20.12.21
 */

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUserCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(PARA_COIN_ID)?.let {
            getCoinsDetailById(it)
        }
    }

    private fun getCoinsDetailById(id: String) {
        getCoinDetailUserCase(id).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coins = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}