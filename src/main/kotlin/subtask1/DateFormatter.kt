package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {
    private val formatter = DateTimeFormatter.ofPattern("dd LLLL, EEEE", Locale("ru"))
    private val monthNameRu = arrayOf(
        "",
        "января",
        "февраля",
        "марта",
        "апреля",
        "мая",
        "июня",
        "июля",
        "августа",
        "сентября",
        "октября",
        "ноября",
        "декабря"
    )
    private val formatterDayOfWeek = DateTimeFormatter.ofPattern("EEEE", Locale("ru"))

    fun toTextDay(day: String, month: String, year: String): String {
        return try {
            val date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            "${date.dayOfMonth} ${monthNameRu[date.monthValue]}, ${date.format(formatterDayOfWeek)}"
        } catch (e: Exception) {
            "Такого дня не существует"
        }
    }
}
