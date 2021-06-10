package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {
    private val formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy")

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if (blockA.isEmpty()) return ""
        if (blockB !in listOf(Int::class, String::class, LocalDate::class)) return ""
        return when (blockB) {
            Int::class -> {
                blockA.mapNotNull { elem ->
                    if (elem is Int) elem else null
                }.sum()
            }
            String::class -> {
                blockA.mapNotNull { elem ->
                    if (elem is String) elem else null
                }.joinToString(separator = "")
            }
            // в виде строки в формате dd.MM.yyyy
            LocalDate::class -> {
                blockA.mapNotNull { elem ->
                    if (elem is LocalDate) elem else null
                }.sorted().last().format(formatterDate).orEmpty()
            }
            else -> ""
        }
    }
}
