package com.pdm.foodspot.ui.screens.restaurantscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pdm.foodspot.ui.components.MainTopBar
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Search


@Composable
fun RestaurantsScreen(
    viewModel: RestaurantsScreenViewModel,
    onNavigateToDetail: (Int) -> Unit,
    onNavigateToSearch: () -> Unit

) {
    Scaffold(
        topBar = {
            MainTopBar(
                title = "Restaurants" ,
                actions = {
                    IconButton(onClick = onNavigateToSearch) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )


        }
    ) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding)) {

        }


    }


}
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Button(
//            onClick = {onNavigateToDetail(1)
//            }
//        ) { Text("Screen 1") }
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = onNavigateToSearch) {Text("Screen 2") }
//    }



