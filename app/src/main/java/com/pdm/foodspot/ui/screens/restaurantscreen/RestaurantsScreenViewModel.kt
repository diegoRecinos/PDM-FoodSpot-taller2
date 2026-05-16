package com.pdm.foodspot.ui.screens.restaurantscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm.foodspot.data.model.Restaurant
import com.pdm.foodspot.data.repository.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

import com.pdm.foodspot.data.repository.RestaurantApiRepository

//define ui state
data class RestaurantsUiState(
    val restaurants: List<Restaurant> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
class RestaurantsScreenViewModel(private val repository: RestaurantRepository = RestaurantApiRepository()) : ViewModel() {
    //internal mutable  state
    private val _uiState = MutableStateFlow(RestaurantsUiState() )

    //public statet for ui (only read)
    val uiState: StateFlow<RestaurantsUiState> = _uiState.asStateFlow()

    init {
        fetchRestaurants( )
    }

    //logic to fetch restaurants and obtain data
     fun fetchRestaurants() {
        viewModelScope.launch {
            //update loading state
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            try {
                //call suspend function to fetch restaurants
                val restaurants = repository.getRestaurants()

                //update ui state with fetched restaurants
                _uiState.update {
                    it.copy(restaurants = restaurants, isLoading = false)
                }

            } catch (e: Exception) {

                //catch error
                _uiState.update {
                    it.copy(isLoading = false, errorMessage = "error al cargar los restaurantes")
                }
            }

        }
    }


}