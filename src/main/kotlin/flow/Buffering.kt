package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            generate()
                .buffer()
                .collect {
                    delay(300L)
                    println(it)
                }
        }
        println("Time: $time ms")
    }
}

fun generate() = flow {
    for (i in 1..10) {
        delay(100L)
        emit(i)
    }
}