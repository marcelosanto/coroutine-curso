import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {

    runBlocking {
        launch(CoroutineName("myCoroutine")) {
            println("Task run from ${coroutineContext[CoroutineName.Key]}")
        }

    }


}