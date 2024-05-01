import java.util.Scanner

object InputVerificator {
    private val currentScanner = Scanner(System.`in`)
    private const val noDups = true
    val rootNodeAlgorithm:(archiveDupesList:List<String>)->PrototypeArchive<Note> ={archiveDupes ->
        println("Введите название нового Архива:")
        val newArchiveName=if(noDups) getNotDuplicateStringInput(archiveDupes) else getStringInput()
        PrototypeArchive(newArchiveName,nodeAlgorithm)
    }
    private val nodeAlgorithm:(nodeDupesList:List<String>)->Note ={dupes ->
        println("Введите название новой заметки:")
        val newNoteName=if(noDups) getNotDuplicateStringInput(dupes) else getStringInput()
        println("Введите описание заметки:")
        val newNoteDescription=getStringInput()
        Note(newNoteName,newNoteDescription)}
    fun getStringInput():String{
        var currentInput =""
        var filterFlag=false
        while (!filterFlag){
            currentInput=currentScanner.nextLine().trim()
            if(currentInput.isNotEmpty()){filterFlag=true}
            else{println("Вы не ввели данные, попробуйте снова")}
        }
        return currentInput
    }
    private fun getNotDuplicateStringInput(presentStrings:List<String>):String{
        var filteFlag= false
        var currentInput =""
        while(!filteFlag){
            currentInput= getStringInput()
            if(!presentStrings.contains(currentInput))filteFlag=true else{
                println("такой пункт уже существует, выберите другое название:")
            }
        }
        return currentInput
    }
}