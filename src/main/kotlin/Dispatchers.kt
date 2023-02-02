import kotlinx.coroutines.*

/**
 * Dispatchers.Main: use este agente para executar uma corrotina na linha de execução principal do Android. Ele só deve ser usado para interagir com a IU e realizar um trabalho rápido. Exemplos incluem chamar funções suspend, executar operações de framework de IU do Android e atualizar objetos LiveData.
 * Dispatchers.IO: este agente é otimizado para executar E/S de disco ou rede fora da linha de execução principal. Exemplos incluem uso do componente Room, leitura ou gravação de arquivos e execução de qualquer operação de rede.
 * Dispatchers.Default: este agente é otimizado para realizar trabalho intensivo da CPU fora da linha de execução principal. Exemplos de casos de uso incluem classificação de uma lista e análise de JSON.
 **/
fun main(args: Array<String>) {

    runBlocking {
//        launch(Dispatchers.Main) {
//            println("Main dispatcher. Thread: ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined1 dispatcher. Thread: ${Thread.currentThread().name}")
            delay(100L)
            println("Unconfined2 dispatcher. Thread: ${Thread.currentThread().name}")

        }

        launch(Dispatchers.Default) {
            println("Default dispatcher. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO dispatcher. Thread: ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyThread")) {
            println("newSingleThreadContext. Thread: ${Thread.currentThread().name}")
        }

    }

}
