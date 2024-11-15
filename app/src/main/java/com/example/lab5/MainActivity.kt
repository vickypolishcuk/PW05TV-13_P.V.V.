package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab5.ui.theme.Lab5Theme
import androidx.navigation.compose.rememberNavController
import com.example.lab5.functions.CalculatorsFunctions
import com.example.lab5.ui.calculator1.Calculator1
import com.example.lab5.ui.calculator2.Calculator2
import com.example.lab5.ui.firstScreen.FirstScreen

enum class Routes {
    MAIN_SCREEN,
    CALCULATOR_1,
    CALCULATOR_2
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                val navController = rememberNavController()
                val calculatorsFunctions = CalculatorsFunctions()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.MAIN_SCREEN.name,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = Routes.MAIN_SCREEN.name) {
                            FirstScreen(
                                onCalculator1Navigate = { navController.navigate(route = Routes.CALCULATOR_1.name) },
                                onCalculator2Navigate = { navController.navigate(route = Routes.CALCULATOR_2.name) },
                            )
                        }
                        composable(route = Routes.CALCULATOR_1.name) {
                            Calculator1(
                                goBack = { navController.navigate(route = Routes.MAIN_SCREEN.name )},
                                calculatorsFunctions = calculatorsFunctions
                            )
                        }
                        composable(route = Routes.CALCULATOR_2.name) {
                            Calculator2(goBack = { navController.navigate(route = Routes.MAIN_SCREEN.name )},
                                calculatorsFunctions = calculatorsFunctions
                            )
                        }
                    }
                }
            }
        }
    }
}