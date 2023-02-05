package flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking { mapOperator() }
}

suspend fun mapOperator() {
    (1..10).asFlow()
//        .map {
//            delay(500L)
//            "mapping $it"
//        }
//        .filter {
//            it % 2 == 0
//        }
        .transform {
            emit("Emitting string value $it")
            emit(it)
        }
        .collect {
            println(it)
        }
}
