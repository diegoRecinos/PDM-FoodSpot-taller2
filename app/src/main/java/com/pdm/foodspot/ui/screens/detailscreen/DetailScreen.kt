package com.pdm.foodspot.ui.screens.detailscreen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.pdm.foodspot.data.model.Dish
import com.pdm.foodspot.data.model.Restaurant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    restaurantId: Int,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailScreenViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(restaurantId) {
        viewModel.fetchRestaurantById(restaurantId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = uiState.restaurant?.name ?: "Detalle del Restaurante") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver atrás",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(65,46,135),
                    titleContentColor = Color.White,
                )
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else if (uiState.errorMessage != null) {
                Text(
                    text = uiState.errorMessage!!,
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.error
                )
            } else {
                uiState.restaurant?.let { restaurant ->
                    RestaurantDetailContent(
                        restaurant = restaurant,
                        onAddToCart = { dish ->
                            Toast.makeText(
                                context,
                                "${dish.name} agregado al carrito",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            }
        }
    }
}