import kotlinx.coroutines.*

fun main() {
  println("block")
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
      launch {
        delay(1500L)
        println("Task from coroutineScope")
      }
    }
  }

  println("continue")
}