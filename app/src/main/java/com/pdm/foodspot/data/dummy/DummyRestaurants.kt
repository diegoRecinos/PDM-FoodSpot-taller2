package com.pdm.foodspot.data.dummy

import com.pdm.foodspot.data.model.Dish
import com.pdm.foodspot.data.model.Restaurant

val restaurantList = listOf(
    Restaurant(
        id = 1,
        name = "The Gourmet Burger",
        description = "Juicy artisanal burgers with premium ingredients and secret sauces.",
        imageUrl = "https://images.unsplash.com/photo-1571091718767-18b5b1457add",
        categories = listOf("Burgers", "Fast Food", "American"),
        menu = burgerDishes
    ),
    Restaurant(
        id = 2,
        name = "Pizza del Mondo",
        description = "Authentic wood-fired pizzas inspired by traditional Italian recipes.",
        imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591",
        categories = listOf("Pizza", "Italian", "Pasta"),
        menu = pizzaDishes
    ),
    Restaurant(
        id = 3,
        name = "Sakura Sushi Bar",
        description = "Fresh and delicate sushi, sashimi, and Japanese specialty rolls.",
        imageUrl = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c",
        categories = listOf("Japanese", "Sushi", "Asian"),
        menu = burgerDishes
    ),
    Restaurant(
        id = 4,
        name = "Taco Fiesta",
        description = "Vibrant Mexican street food with bold flavors and fresh salsas.",
        imageUrl = "https://images.unsplash.com/photo-1565299585323-38d6b0865b47",
        categories = listOf("Mexican", "Tacos", "Street Food"),
        menu = pizzaDishes
    )
)
