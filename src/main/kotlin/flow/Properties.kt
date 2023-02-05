package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val numbersFlow = sendNumbersX()
        println("Flow hasn't started yet")
        println("Flow has started")

        withTimeoutOrNull(1000L) {
            numbersFlow.collect {
                println(it)
            }
        }
    }
    println("Flow has finished")
}

fun sendNumbersX() = flow {
    for (i in 1..10) {
        delay(400L)
        emit(i)
    }
}