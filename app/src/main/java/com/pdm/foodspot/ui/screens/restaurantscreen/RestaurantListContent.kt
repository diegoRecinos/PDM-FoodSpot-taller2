package com.pdm.foodspot.ui.screens.restaurantscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pdm.foodspot.data.model.Restaurant

@Composable
fun RestaurantListContent(
    restaurants: List<Restaurant>,
    onRestaurantClick: (Int) -> Unit
) {
    // Agrupamos los restaurantes por cada una de sus categorías
    val categoriesMap = remember(restaurants) {
        val map = mutableMapOf<String, MutableList<Restaurant>>()
        restaurants.forEach { restaurant ->
            restaurant.categories.forEach { category ->
                map.getOrPut(category) { mutableListOf() }.add(restaurant)
            }
        }
        map
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        categoriesMap.forEach { (categoryName, list) ->
            item {
                CategorySection(
                    categoryName = categoryName,
                    restaurants = list,
                    onRestaurantClick = onRestaurantClick
                )
            }
        }
    }
}