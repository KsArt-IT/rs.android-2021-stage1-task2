package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val regex = """[^${b.toLowerCase()}]""".toRegex()
        val aUpper = a.toLowerCase().replace(regex, "").toUpperCase()
        return if (aUpper == b) "YES" else "NO"
    }
}
