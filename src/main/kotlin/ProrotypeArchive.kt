open class PrototypeArchive<T:PrintableUnit>(archiveName: String, val menuAddingAlgorithm:(List<String>)->T):PrintableUnit(archiveName) {
    private val myArchiveList: MutableList<T> =ArrayList()
    override fun showInTerminal() {
        var notExited=true
        while (notExited){
            println("текущий статус ${name}:")
            println("0.-Создать новый элемент")
            myArchiveList.forEachIndexed{index,element->println("${index+1}.- ${element.name}")}
            println("${myArchiveList.size+1}.- Выход")
            println("Ваши действия? Для навигации в меню вводи соответствующие цифры")
            val chosenAnswer= InputVerificator.getStringInput()
            if(chosenAnswer.all{it in '0'..'9'}){
                when(val chosenMenuOption= chosenAnswer.toInt()){
                    0->{
                        val listForDupsChecking = mutableListOf<String>()
                        myArchiveList.forEach({element->listForDupsChecking.add(element.name)})
                        myArchiveList.add(menuAddingAlgorithm(listForDupsChecking))}
                    (myArchiveList.size+1) -> notExited=false
                    in 1..myArchiveList.size ->{
                        println("Открываю...")
                        myArchiveList.get(chosenMenuOption-1).showInTerminal() //запускаю цикл дочернего объекта
                    }
                    else -> {
                        println("Такого пункта нет, попробуйте снова")
                    }
                }
            } else{
                println("Вводите положительные числа согласно выведенным пунктам меню в диапозоне от 0 до ${myArchiveList.size+1}")
            }
        }
        println("Назад...")
    }
}
