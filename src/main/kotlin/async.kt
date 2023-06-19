import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
  runBlocking {
    val firstDeferred = async { getFirstValue() }
    val secondDeferred = async { getSecondValue() }

    println("Start")
    delay(500L)
    println("Start123")

    val firstVal = firstDeferred.await()
    val secondVal = secondDeferred.await()

    println("total is ${firstVal + secondVal}")

  }
}

suspend fun getFirstValue(): Int {
  delay(200L)
  val value = Random.nextInt(100)
  println("Returning first value $value")
  return value
}

suspend fun getSecondValue(): Int {
  delay(3000L)
  val value = Random.nextInt(100)
  println("Returning second value $value")
  return value
}