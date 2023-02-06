package flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        onCompletion()
    }
}

private suspend fun onCompletion() {
    (1..5).asFlow()
        .onEach { check(it != 2) }
        .onCompletion { cause ->
            if (cause != null) {
                println("Flow completed with ${cause.message}")
            } else println("Flow completed successfully")

        }
        .catch { e -> println("Caught exception ${e.message}") }
        .collect { println(it) }

}

private suspend fun catch() {
    (1..5).asFlow()
        .onEach { check(it != 2) }
        .catch { e -> println("Caught exception ${e.message}") }
        .collect { println(it) }

}

private suspend fun tryCatch() {
    try {
        (1..5).asFlow()
            .onEach { check(it != 2) }
            .collect { println(it) }
    } catch (e: Exception) {
        println("Caught exception ${e.message}")
    }
}