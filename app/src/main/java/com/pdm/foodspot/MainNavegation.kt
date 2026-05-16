package com.pdm.foodspot

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm.foodspot.data.repository.RestaurantApiRepository

import com.pdm.foodspot.ui.screens.restaurantscreen.RestaurantsScreen
import com.pdm.foodspot.ui.screens.detailscreen.DetailScreen
import com.pdm.foodspot.ui.screens.restaurantscreen.RestaurantsScreenViewModel
import com.pdm.foodspot.ui.screens.searchscreen.SearchScreen

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

                    //instanciar el viewmodel con factory para inyectar el repositorio
                    val viewModel: RestaurantsScreenViewModel = viewModel()

                    RestaurantsScreen(
                        //pasar el viewmodel
                        viewModel = viewModel,
                        onNavigateToDetail = { id ->
                            backStack.add(Routes.DetailScreen(restaurantId = id)) },
                        onNavigateToSearch = { backStack.add(Routes.SearchScreen) }
                    )
                }

                entry<Routes.DetailScreen>{ route ->
                    DetailScreen(
                        restaurantId = route.restaurantId,
                        onBack = { backStack.removeLastOrNull() }
                    )
                }

                entry<Routes.SearchScreen>{
                    SearchScreen(onBack = {backStack.removeLastOrNull()})
                }

            }

        )
    }

}