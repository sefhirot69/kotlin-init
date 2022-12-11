package com.codely.demo

import java.time.LocalDate
import java.time.Period
import kotlin.system.exitProcess

fun main() {
    println("Please enter a date with the format <yyyy-MM-dd>")
    val line = supportNullableString(readLine())

    if(line.isNullOrEmpty()) {
        println("The date is not valid")
        exitProcess(1);
    }
    val input = LocalDate.parse(line)
    println("You wrote $input")
    val currentDate = LocalDate.now()
    val difference = Period.between(input, currentDate)
    println("The difference between the date you wrote and today is ${difference.years}")

}

fun supportNullableString(line: String?) = line
