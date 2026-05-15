package com.pdm.foodspot.data.repository

import com.pdm.foodspot.data.model.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurants(): List<Restaurant>
    suspend fun getRestaurantById(id: Int): Restaurant?
    suspend fun searchRestaurants(query: String): List<Restaurant>
}