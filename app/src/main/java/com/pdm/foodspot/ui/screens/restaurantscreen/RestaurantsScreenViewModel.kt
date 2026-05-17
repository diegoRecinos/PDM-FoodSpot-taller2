package com.pdm.foodspot.ui.screens.restaurantscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm.foodspot.data.model.Restaurant
import com.pdm.foodspot.data.repository.RestaurantApiRepository
import com.pdm.foodspot.data.repository.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// The UI State  what information the screen needs to render loading status, errors, data
data class RestaurantsUiState(
    val restaurants: List<Restaurant> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

// The ViewModel controls the data and logic of the screen survives configuration changes
class RestaurantsScreenViewModel(
    // instance of the repository, Connecting to the repository  to fetch data using an interface
    private val repository: RestaurantRepository = RestaurantApiRepository()) : ViewModel() {
    
    // Private state: viewmodel observes the state of the UI and updates it when the data changes
    private val _uiState = MutableStateFlow(RestaurantsUiState() )

    // Public state: reads the variable the View subscribes to this to know what to draw, but cannot modify it
    val uiState: StateFlow<RestaurantsUiState> = _uiState.asStateFlow()

    init {
        // Trigger the initial data fetch when the ViewModel is created
        fetchRestaurants( )
    }

    // fetch restaurants asynchronously
     fun fetchRestaurants() {
         //A Coroutine Builder suspend function
         // cannot be called from a regular function directly. It can only be called from viewModelScope.launch
        viewModelScope.launch {
            // Set the state to "loading" before starting the request
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            try {
                // Request data from the repository (the data layer)
                val restaurants = repository.getRestaurants()

                // If successful, update the state with the list and stop the loading indicator
                _uiState.update {
                    it.copy(restaurants = restaurants, isLoading = false)
                }

            } catch (e: Exception) {
                // save the error message to the state so the UI can notify the user
                _uiState.update {
                    it.copy(isLoading = false, errorMessage = "Error loading restaurants")
                }
            }
        }
    }
}
