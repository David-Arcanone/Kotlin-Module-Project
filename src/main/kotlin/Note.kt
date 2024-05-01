class Note(private val noteName: String, private val description:String):PrintableUnit(noteName){
    override fun showInTerminal(){
        println("Открыта заметика: $noteName")
        println("Описание заметки:\n$description")
        println("Возвращение в родительский Архив\n")
    }
}
