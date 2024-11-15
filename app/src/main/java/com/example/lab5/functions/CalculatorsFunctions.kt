package com.example.lab5.functions

class CalculatorsFunctions {
    // Функція для обчислення частоти відмов одноколової та двоколової системи електропередачі
    fun function1(value1: Int, value2: Int): Pair<Double, Double> {

        // Значення частот відмов для кожного елемента
        val num1 = 0.01
        val num2 = 0.007 * value1
        var num3 = 0.015
        val num4 = 0.02
        val num5 = 0.03 * value2
        val num6 = 0.02

        // Значення тривалості відновлення для кожного елемента
        val t1 = 30
        val t2 = 10
        val t3 = 100
        val t4 = 15
        val t5 = 2

        // Обчислення частоти відмов одноколової системи
        val result1 = num1 + num2 + num3 + num4 + num5
        // Середня тривалість відновлення
        val t = (num1 * t1 + num2 * t2 + num3 * t3 + num4 * t4 + num5 * t5) / result1
        // Коефіцієнт аварійного простою одноколової системи
        val ka = (result1 * t) / 8760
        // Коефіцієнт планового простою одноколової системи
        val kp = 1.2 * (43.0 / 8760.0)
        // Частота відмов одночасно двох кіл двоколової системи
        val result2 = 2 * result1 * (ka + kp)
        // Частота відмов двоколової системи з урахуванням секційного вимикача (num6)
        val fixedResult2 =  result2 + num6

        // Повернення результату типом Pair, щоб повернути обидва результати
        return Pair(result1, fixedResult2)
    }

    // Функція для обчислення збитків від переривання електропостачання
    fun function2(value1: Double, value2: Double): Double {
        // Обчислення математичного сподівання аварійного недовідпущення електроенергії
        val ma = 0.01 * 0.045 * 5120 * 6451
        // Обчислення математичного сподівання планового недовідпущення електроенергії
        val mp = 0.004 * 5120 * 6451
        // Обчислення та повернення математичного сподівання збитків від переривання електропостачання
        return value1 * ma + value2 * mp
    }
}