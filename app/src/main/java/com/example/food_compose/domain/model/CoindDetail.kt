package com.example.food_compose.domain.model

import com.example.food_compose.data.dto.Team

/**
 * Created by Sopo Vardidze on 13.12.21
 */
data class CoindDetail(
    val coindId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<Team>
)
