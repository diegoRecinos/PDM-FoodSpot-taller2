package com.pdm.foodspot.ui.screens.searchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm.foodspot.data.model.Restaurant
import com.pdm.foodspot.data.repository.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class SearchUiState(
    val query: String = "",
    val searchResults: List<Restaurant> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)


class SearchScreenViewModel(private val repository: RestaurantRepository) : ViewModel(){

    private val _uiState = MutableStateFlow(SearchUiState())

    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun onQueryChange(newQuery: String) {
        _uiState.update { it.copy(query = newQuery) }
        searchRestaurants(newQuery)

    }

    private fun searchRestaurants(query: String) {
        if(query.isBlank()){
            _uiState.update { it.copy(searchResults = emptyList()) }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {

                val results = repository.searchRestaurants(query)
                _uiState.update { it.copy(searchResults = results, isLoading = false) }


            }catch (e: Exception){

                _uiState.update { it.copy(isLoading = false, errorMessage = "Error al buscar restaurantes") }

            }
        }



    }

}