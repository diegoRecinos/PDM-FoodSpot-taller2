package com.pdm.foodspot.data.repository

import com.pdm.foodspot.data.dummy.restaurantList
import com.pdm.foodspot.data.model.Restaurant
import kotlinx.coroutines.delay

/**
 * Repository restaurant data.
 */
class RestaurantApiRepository : RestaurantRepository {
    //Kotlin Coroutines suspend run in a separate thread without freezing the UI.
    override suspend fun getRestaurants(): List<Restaurant> {
        delay(1000) // Simulates network latency
        return restaurantList
    }

    override suspend fun getRestaurantById(id: Int): Restaurant? {
        delay(2000) // Simulates a longer network delay for details
        return restaurantList.find { it.id == id }
    }

    /*
     *Case-insensitive: uses 'ignoreCase = true' in string comparison.
     *Search by Dish: checks if any menu item matches the query.
     *Returns Restaurants: results are filtered Restaurant objects, not individual dishes.
     */
    override suspend fun searchRestaurants(query: String): List<Restaurant> {
        // The search is case-insensitive and returns the restaurants themselves,
        // even if the match is found within a menu item (dish).
        return restaurantList.filter { restaurant ->
            restaurant.name.contains(query, ignoreCase = true) ||
                    restaurant.menu.any { it.name.contains(query, ignoreCase = true) }
        }
    }

}