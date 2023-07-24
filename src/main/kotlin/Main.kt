data class NoteArchive(val name: String, val notes: MutableList<Note> = mutableListOf())

val archives = mutableListOf<NoteArchive>()


fun main() {
    while (true) {
        printArchiveMenu()
        when (val choice = readLine()?.toIntOrNull()) {
            0 -> createArchive()
            in 1..archives.size -> handleArchive(archives[choice!! - 1])
            else -> {
                if (choice == archives.size + 1) return
                println("Неизвестный выбор. Пожалуйста, введите корректную цифру.")
            }
        }
    }
}// не знаю насколько важно было чтобы он выводил текст на несуществующую цифру, поэтому я просто объединил

fun printArchiveMenu() {
    println("\nСписок архивов:")
    println("0. Создать архив")
    archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
    println("${archives.size + 1}. Выход")
} // Не знаю можно ли говорить о том что он совпадает с printNoteMenu. Конструкция конечно одинаковая, но код не тот же00

fun createArchive() {
    print("Введите название нового архива: ")
    val name = readLine()
    if (name != null) {
        archives.add(NoteArchive(name))
    }
}
