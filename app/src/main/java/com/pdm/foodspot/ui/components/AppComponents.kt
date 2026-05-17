package com.pdm.foodspot.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.layout.RowScope
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    title: String,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = title) },
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(65, 46,135),
            titleContentColor = Color.White,
        ),
        modifier = modifier
    )
}

@Composable
fun MainBottomBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar {
        val items = listOf(
            NavigationItem("Home", Icons.Default.Home, "home"),
            NavigationItem("Profile", Icons.Default.Person, "profile"),
            NavigationItem("Settings", Icons.Default.Settings, "settings")
        )

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = { onNavigate(item.route) }
            )
        }
    }
}

data class NavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)