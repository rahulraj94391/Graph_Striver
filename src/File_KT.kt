fun main() {
    print(printName(true))
}


fun printName(boolean: Boolean): String {
    val name = if (boolean) {
        "rahul"
    } else {
        "hari"
    }

    return name
}
