package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        combine()
    }
}

suspend fun combine() {
    val numbers = (1..5).asFlow()
        .onEach { delay(300L) }
    val values = flowOf("One", "Two", "Three", "Four", "Five")
        .onEach { delay(400L) }

    numbers.combine(values) { a, b -> "$a -> $b" }
        .collect { println(it) }
}

suspend fun zip() {
    val english = flowOf("One", "Two", "Three")
    val portuguese = flowOf("Um", "Dois", "Três")

    english.zip(portuguese) { a, b -> "'$a' in Portuguese is '$b'" }
        .collect {
            println(it)
        }
}