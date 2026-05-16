package com.pdm.foodspot.data.dummy

import com.pdm.foodspot.data.model.Dish
import com.pdm.foodspot.data.model.Restaurant

val restaurantList = listOf(
    Restaurant(
        id = 1,
        name = "The Gourmet Burger",
        description = "Juicy artisanal burgers with premium ingredients.",
        imageUrl = "https://images.unsplash.com/photo-1571091718767-18b5b1457add",
        categories = listOf("Comida Rápida"),
        menu = burgerDishes
    ),
    Restaurant(
        id = 2,
        name = "Pizza del Mondo",
        description = "Authentic wood-fired pizzas.",
        imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591",
        categories = listOf("Italiana"),
        menu = pizzaDishes
    ),
    Restaurant(
        id = 3,
        name = "Sakura Sushi Bar",
        description = "Fresh sushi and Japanese specialty rolls.",
        imageUrl = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c",
        categories = listOf("Asiática"),
        menu = burgerDishes
    ),
    Restaurant(
        id = 4,
        name = "Taco Fiesta",
        description = "Vibrant Mexican street food.",
        imageUrl = "https://images.unsplash.com/photo-1565299585323-38d6b0865b47",
        categories = listOf("Comida Rápida"),
        menu = pizzaDishes
    ),
    Restaurant(
        id = 5,
        name = "Green Garden",
        description = "Fresh salads and healthy bowls.",
        imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
        categories = listOf("Saludable"),
        menu = burgerDishes
    ),
    Restaurant(
        id = 6,
        name = "Pasta Palace",
        description = "Homemade pasta with traditional sauces.",
        imageUrl = "https://images.unsplash.com/photo-1473093226795-af9932fe5856",
        categories = listOf("Italiana"),
        menu = pizzaDishes
    ),
    Restaurant(
        id = 7,
        name = "Sweet Dreams",
        description = "Cakes, cookies and delicious pastries.",
        imageUrl = "https://images.unsplash.com/photo-1551024601-bec78aea704b",
        categories = listOf("Postres"),
        menu = burgerDishes
    ),
    Restaurant(
        id = 8,
        name = "Wok Express",
        description = "Stir-fry noodles and Asian flavors.",
        imageUrl = "https://images.unsplash.com/photo-1512058564366-18510be2db19",
        categories = listOf("Asiática"),
        menu = pizzaDishes
    ),
    Restaurant(
        id = 9,
        name = "Healthy Bites",
        description = "Organic ingredients for a better life.",
        imageUrl = "https://images.unsplash.com/photo-1490645935967-10de6ba17061",
        categories = listOf("Saludable"),
        menu = burgerDishes
    ),
    Restaurant(
        id = 10,
        name = "Coffee Haven",
        description = "Premium coffee and refreshing beverages.",
        imageUrl = "https://images.unsplash.com/photo-1541167760496-1628856ab772",
        categories = listOf("Bebidas"),
        menu = pizzaDishes
    ),
    Restaurant(
        id = 11,
        name = "Ice Cream Joy",
        description = "Handcrafted ice cream and shakes.",
        imageUrl = "https://images.unsplash.com/photo-1497034825429-c343d7c6a68f",
        categories = listOf("Postres"),
        menu = burgerDishes
    ),
    Restaurant(
        id = 12,
        name = "Smoothie Bar",
        description = "Natural fruit smoothies and juices.",
        imageUrl = "https://images.unsplash.com/photo-1536304993881-ff6e9eefa2a6",
        categories = listOf("Bebidas"),
        menu = pizzaDishes
    ),
    Restaurant(
        id = 13,
        name = "Chicken Crispy",
        description = "The best fried chicken in town.",
        imageUrl = "https://images.unsplash.com/photo-1626082927389-6cd097cdc6ec",
        categories = listOf("Comida Rápida"),
        menu = burgerDishes
    )
)
