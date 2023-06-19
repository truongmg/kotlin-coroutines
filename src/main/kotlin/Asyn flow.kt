import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
  var arr = listOf(1, 2, 3, 4)
  arr.reduce { acc, i ->
    println("acc is $acc")
    println("i is $i")
    acc + i
  }
}

fun sendPrimes(): Flow<Int> = flow {
  val primesList = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
  primesList.forEach {
    delay(it * 100L)
    emit(it)
  }
}

fun sendNumbers() = flow {
  for (i in 1..10)
    emit(i)
}