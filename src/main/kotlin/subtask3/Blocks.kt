package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {
    private val formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy")

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if (blockA.isEmpty()) return ""
        return when (blockB) {
            Int::class -> { blockA.filterIsInstance<Int>().sum() }
            String::class -> { blockA.filterIsInstance<String>().joinToString(separator = "") }
            LocalDate::class -> { blockA.filterIsInstance<LocalDate>().sorted().last().format(formatterDate).orEmpty() }
            else -> ""
        }
    }
}
