import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    mapOperator()
  }
}

suspend fun mapOperator() {
  (1..10).asFlow()
    .map {
      delay(500L)
      "mapping $it"
    }
    .collect {
      println(it)
    }
}