package com.pdm.foodspot.ui.screens.detailscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm.foodspot.data.model.Restaurant
import com.pdm.foodspot.data.repository.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DetailUiState(
    val restaurant: Restaurant? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

class DetailScreenViewModel(private val repository: RestaurantRepository) : ViewModel(){
    private val _uiState = MutableStateFlow(DetailUiState())

    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun fetchRestaurantById(id: Int){

        viewModelScope.launch {

            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            try {
                val restaurant = repository.getRestaurantById(id)

                if (restaurant != null){
                _uiState.update { it.copy(restaurant = restaurant, isLoading = false) }

                }else{
                _uiState.update { it.copy(isLoading = false, errorMessage = "Restaurant not found") }
                }

            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, errorMessage = "Error loading restaurant") }
            }
        }
    }
}