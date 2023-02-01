import kotlinx.coroutines.*

fun main(args: Array<String>) {

    runBlocking {
        launch(CoroutineName("myCoroutine")) {
            println("Task run from ${coroutineContext[CoroutineName.Key]}")
        }

    }


}