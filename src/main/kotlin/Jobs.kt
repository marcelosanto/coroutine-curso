import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Um Job (link em inglês) é um gerenciador de uma corrotina. Cada corrotina criada com launch ou async retorna uma instância Job que identifica exclusivamente a corrotina e gerencia o ciclo de vida dela. Você também pode transmitir um Job para um CoroutineScope e gerenciar ainda mais o ciclo de vida, conforme mostrado no exemplo a seguir:
 **/
fun main(args: Array<String>) {

    runBlocking {
        val job1 = launch {
            //delay(3000L)
            println("Job1 Launched")

            val job2 = launch {
                println("Job2 launched")
                delay(3000L)
                println("Job2 is finishing")
            }

            job2.invokeOnCompletion {
                println("Job2 completed")
            }

            val job3 = launch {
                println("Job3 launched")
                delay(3000L)
                println("Job3 is finishing")
            }

            job3.invokeOnCompletion {
                println("Job3 completed")
            }
        }

        job1.invokeOnCompletion {
            println("Job1 completed")
        }

        delay(500L)
        println("Job1 will be cancelled")
        job1.cancel()
    }


}