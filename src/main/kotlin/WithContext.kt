import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Como withContext() permite controlar o pool de linhas de execução de qualquer linha de código sem introduzir callbacks, é possível aplicá-lo a funções muito pequenas, como ler um banco de dados ou executar uma solicitação de rede.
 * Uma boa prática é usar withContext() para garantir que todas as funções sejam protegidas, o que significa que você pode chamar a função a partir da linha de execução principal.
 * Dessa forma, o autor da chamada nunca precisa pensar sobre qual linha de execução tem que ser usada para executar a função.
 * **/
fun main(args: Array<String>) {
    runBlocking {
        launch(Dispatchers.Default) {
            println("First context: $coroutineContext")
            withContext(Dispatchers.IO) {
                println("Second context: $coroutineContext")
            }
            println("Third context: $coroutineContext")
        }
    }
}
