data class Note(val title: String, val text: String)


fun handleArchive(archive: NoteArchive) {
    while (true) {
        printNoteMenu(archive)
        when (val choice = readLine()?.toIntOrNull()) {
            0 -> createNote(archive)
            in 1..archive.notes.size -> {
                viewNoteText(archive.notes[choice!! - 1])
            }
            else -> {
                if (choice == archive.notes.size + 1) return
                println("Неизвестный выбор. Пожалуйста, введите корректную цифру.")
            }
        }
    }
}



fun printNoteMenu(archive: NoteArchive) {
    println("\nСписок заметок в архиве ${archive.name}:")
    println("0. Создать заметку")
    archive.notes.forEachIndexed { index, note -> println("${index + 1}. ${note.title}") }
    println("${archive.notes.size + 1}. Вернуться к списку архивов")
}

fun createNote(archive: NoteArchive) {
    print("Введите название новой заметки: ")
    val name = readLine()
    print("Введите текст новой заметки: ")
    val text = readLine()
    if (!name.isNullOrBlank() && !text.isNullOrBlank()) {
        archive.notes.add(Note(name, text))
    } else {
        println("Необходимо ввести название и текст заметки.")
    }
}

fun viewNoteText(note: Note) {
    println("Название заметки: ${note.title}\nТекст заметки: ${note.text}")
}




