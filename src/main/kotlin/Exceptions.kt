import kotlinx.coroutines.*

fun main() {
  runBlocking {
    val myHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
      println("Exception handled: ${throwable.localizedMessage}")
    }

    val job = GlobalScope.launch(myHandler) {
      println("Throwing exception from job")
      throw IndexOutOfBoundsException("exception")
    }

    job.join()

    val deferred = GlobalScope.async {
      println("Throwing exception from async")
      throw ArithmeticException("exception from async")
    }

    try {
      deferred.await()

    } catch (e: Exception) {
      println("${e.message}")
    }

  }
}