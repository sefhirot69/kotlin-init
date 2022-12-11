package com.codely.demo

import java.time.LocalDate
import java.time.Period

fun main() {
    println("Please enter a date with the format <yyyy-MM-dd>")
    supportNullableString(readLine()).takeUnless {
        it.isNullOrEmpty() || it.isNullOrBlank()
    }?.let { line ->

        val input = LocalDate.parse(line).also {
            println("You wrote $it")
        }
        with(Period.between(input, LocalDate.now())) {
            println("The difference between the date you wrote and today is ${this.years}")
        }
    }
}

fun supportNullableString(line: String?) = line
