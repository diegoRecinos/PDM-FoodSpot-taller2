package com.pdm.foodspot

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// In Nav3, each destination is an object or a data class
//Serializable convertir esa clase en una ruta de texto y manejar los argumentos de forma segura

@Serializable
//navkey is the key to identify the destination
sealed interface Routes : NavKey {

    @Serializable
    data object HomeScreen: Routes{

    }

    @Serializable
    data object Detail: Routes{

    }

    @Serializable
    data object Search: Routes{

    }

    //nested
    data class SubScreen1(val id: Int): Routes{}

}