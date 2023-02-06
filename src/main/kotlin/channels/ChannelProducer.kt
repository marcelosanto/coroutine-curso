package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        produceSquares()
            .consumeEach {
                println(it)
            }
    }
}

fun CoroutineScope.produceSquares() = produce {
    for (i in 1..5) {
        send(i * i)
    }
}