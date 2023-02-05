package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking { flowOnOperator() }
}

suspend fun flowOnOperator() {
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect {
            println(it)
        }
}

suspend fun reduceOperator() {
    val size = 10
    val factorial = (1..size).asFlow()
        .reduce { acc, value -> acc * value }
    println("Factorial of $size is $factorial")
}

suspend fun takeOperator() {
    (1..10).asFlow()
        .take(2)
        .collect {
            println(it)
        }
}
