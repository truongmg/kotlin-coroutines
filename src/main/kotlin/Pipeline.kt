import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    val numbers = produceNumbers()
    val squares = square(numbers)
    for (i in 1..5)
      println(squares.receive())
    println("done")
    for (i in 1..5)
      println(squares.receive())
    coroutineContext.cancelChildren()
    for (i in 1..5)
      println(squares.receive())

  }
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>) = produce {
  for (x in numbers)
    send(x * x)
}