import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        repeat(1_000_000) {
            launch {
                print("$it ")
            }
        }
    }
}