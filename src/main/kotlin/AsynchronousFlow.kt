import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Receiving prime numbers")
        sendPrimes().collect {
            println(it)
        }
        println("Finished receiving prime numbers")
    }
}

fun sendPrimes(): Flow<Int> = flow {
    val primesList = listOf(2, 3, 5, 7, 9, 11, 17, 19, 23, 29)
    primesList.forEach {
        delay(it * 100L)
        emit(it)
    }
}