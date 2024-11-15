package com.example.lab5.ui.calculator1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab5.functions.CalculatorsFunctions

@Composable
fun Calculator1(
    goBack: () -> Unit,
    calculatorsFunctions: CalculatorsFunctions
) {
    // Ініціалізація змінних
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var value3 by remember { mutableStateOf("") }
    var value4 by remember { mutableStateOf("") }
    var value5 by remember { mutableStateOf("") }
    var value6 by remember { mutableStateOf("") }
    var result1 by remember { mutableStateOf("") }
    var result2 by remember { mutableStateOf("") }

    // Функція обчислення результату
    fun calculate(): Unit {
        // Перетворення String на Int для певних значень для подальших обчислень
        val formattedValue2 = value2.toIntOrNull() ?: 0;
        val formattedValue5 = value5.toIntOrNull() ?: 0;

        // Обчислення результатів
        val (res1, res2) = calculatorsFunctions.function1(formattedValue2, formattedValue5)
        // Присвоєння отриманих значень у раніше визначені змінні
        result1 = res1.toString()
        // Перетворення результату на тип String з 4 знаками після коми
        result2 = String.format("%.4f", res2)
    }

    // Інтерфейс сторінки
    Column(modifier = Modifier.padding(all = 15.dp)) {
        Text("Одноколова система складається з:")
        TextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Елегазовий вимикач") },
            maxLines = 1,
        )
        TextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Довжина ПЛ-110кВ (км)") },
            maxLines = 1,
        )
        TextField(
            value = value3,
            onValueChange = { value3 = it },
            label = { Text("Трансформатор") },
            maxLines = 1,
        )
        TextField(
            value = value4,
            onValueChange = { value4 = it },
            label = { Text("Ввідний вимикач") },
            maxLines = 1,
        )
        TextField(
            value = value5,
            onValueChange = { value5 = it },
            label = { Text("Приєднань 10кВ") },
            maxLines = 1,
        )
        Text("Двоколова система складається з двох ідентичних одноколових та:")
        TextField(
            value = value6,
            onValueChange = { value6 = it },
            label = { Text("Секційного вимикача") },
            maxLines = 1,
        )
        Button(
            onClick = { calculate() }
        ) {
            Text("Обчислити")
        }
        // Веведення результатів
        if (result1.isNotEmpty() and result2.isNotEmpty()) {
            Text("Частота відмов одноколової системи: $result1")
            Text("Частота відмов двоколової системи: $result2")
            if (result1 < result2){
                Text("Отже, надійність одноколової системи електропередачі є значно вищою ніж двоколової")
            } else if(result1 > result2) {
                Text("Отже, надійність двоколової системи електропередачі є значно вищою ніж одноколової")
            } else {
                Text("Отже, надійність двоколової та одноколової систем електропередачі є однаковою")
            }
        }
        // Кнопка для повернення на головний екран
        Box(
            modifier = Modifier.fillMaxSize().padding(top = 100.dp)
        ) {
            Button(
                onClick = goBack,
                modifier = Modifier.align(Alignment.Center) // Розміщення кнопку в центрі
            ) {
                Text("На головну")
            }
        }
    }
}