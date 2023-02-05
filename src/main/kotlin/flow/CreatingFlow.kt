package flow

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        sendNumbers().collect {
            println("Received $it")
        }
    }
}

fun sendNumbers() = flowOf("One", "Two", "Three")


//fun sendNumbers() = listOf(1, 2, 3, 4, 5, 6).asFlow()

//fun sendNumbers() = flow {
//    for (i in 1..10) {
//        emit(i)
//    }
//}