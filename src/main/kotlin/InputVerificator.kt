import java.util.Scanner

class InputVerificator {
    companion object{
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
        private fun getStringInput():String{
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
        fun getMenuInput(maxValue:Int):Int{
            var currentInput =""
            var filterFlag=false
            while (!filterFlag){
                currentInput= getStringInput()
                if(currentInput.all{it in '0'..'9'}){
                    filterFlag=true
                }else{
                    println("Вводите положительные числа согласно выведенным пунктам меню в диапозоне от 0 до $maxValue")
                }
            }
            return currentInput.toInt()
        }
    }
}