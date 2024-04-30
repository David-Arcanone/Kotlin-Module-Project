fun main() {
    println("Программа работы с архивами запущена")
    val rootArchive =PrototypeArchive<PrototypeArchive<Note>>("Главное меню", InputVerificator.rootNodeAlgorithm)
    rootArchive.showInTerminal()
    println("Завершение работы")
}


