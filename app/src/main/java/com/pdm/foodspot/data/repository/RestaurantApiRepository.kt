package com.pdm.foodspot.data.repository

import com.pdm.foodspot.data.dummy.restaurantList
import com.pdm.foodspot.data.model.Restaurant
import kotlinx.coroutines.delay

class RestaurantApiRepository : RestaurantRepository {
    override suspend fun getRestaurants(): List<Restaurant> {
        delay(2000)
        return restaurantList
    }

    override suspend fun getRestaurantById(id: Int): Restaurant? {
        delay(5000)
        return restaurantList.find { it.id == id }
    }

    override suspend fun searchRestaurants(query: String): List<Restaurant> {
        return restaurantList.filter { restaurant ->
            restaurant.name.contains(query, ignoreCase = true) ||
                    restaurant.menu.any { it.name.contains(query, ignoreCase = true) }
        }
    }

}