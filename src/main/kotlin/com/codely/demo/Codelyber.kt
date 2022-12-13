package com.codely.demo

import java.time.LocalDate
import java.time.Period
import kotlin.system.exitProcess

fun main() {
    println("Please enter a date with the format <yyyy-MM-dd>")
    supportNullableString(readLine()).takeUnless {
        it.isNullOrEmpty() || it.isNullOrBlank()
    }?.let {
        LocalDate.parse(it)
    }.apply {
        if ( null == this) {
           println("The date is not valid");
           exitProcess(1);
        }
    }?.also {
        println("You wrote $it")
    }.run {
        with(Period.between(this, LocalDate.now())) {
            println("The difference between the date you wrote and today is ${this.years}")
        }
    }

}

fun supportNullableString(line: String?) = line
