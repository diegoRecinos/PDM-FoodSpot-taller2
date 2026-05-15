package com.pdm.foodspot

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

import com.pdm.foodspot.ui.screens.restaurantscreen.RestaurantsScreen
import com.pdm.foodspot.ui.screens.detailscreen.Detail
import com.pdm.foodspot.ui.screens.searchscreen.Search

@Composable
fun App(modifier: Modifier = Modifier){
    //creando el backstack
    //backstack needs to know the initial destination
    val backStack = rememberNavBackStack(Routes.RestaurantScreen)

    Scaffold(
        modifier = Modifier.fillMaxSize(),

    ) { innerPadding ->

        //navdisplay contenedor que renderiza las pantallas
        NavDisplay(
            backStack = backStack,
            modifier = Modifier.padding(innerPadding),
            //maneja boton de atras
            onBack = { backStack.removeLastOrNull()},

            entryProvider = entryProvider{
                //mapear cada objeto de routes.kt a un composable
                entry<Routes.RestaurantScreen>{
                    RestaurantsScreen(
                        onNavigateToDetail = { backStack.add(Routes.DetailScreen) },
                        onNavigateToSearch = { backStack.add(Routes.SearchScreen) }
                    )
                }

                entry<Routes.DetailScreen>{
                    Detail(onBack = { backStack.removeLastOrNull() })
                }

                entry<Routes.SearchScreen>{
                    Search(onBack = {backStack.removeLastOrNull()})
                }

            }

        )
    }

}