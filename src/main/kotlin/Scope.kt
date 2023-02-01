import kotlinx.coroutines.*

fun main(args: Array<String>) {
    println("Program execution will now block")

    runBlocking {
        launch {
            delay(1000L)
            println("Task from runBlocking")
        }

        GlobalScope.launch {
            delay(500L)
            println("Task from GlobalScope")
        }

        coroutineScope {
            delay(1500L)
            println("Task from coroutineScope")
        }
    }

    println("Program execution wil now continue")
}