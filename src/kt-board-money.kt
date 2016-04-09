/**
 * kt-board-money - доска металлов и валют из банков
 * Created by oilnur on 09.04.16.
 */

class Kurs {
    var namebank: String? = null // название банка
    var valuta: String? = null  //  название валюты
    var pokupka: Float? = null  //  покупка валюты (покупает банк)
    var prodaja: Float? = null  //  продажа валюты  (продает банк)

    //парсинг банка с именем nbank, возвращает false - если ошибка парсинга
    fun parsebank(nbank: String?): Boolean {
        return true
    }

    fun print() {
        println("namebank= $namebank")
        println("valuta=   $valuta")
        println("pokupka=  $pokupka")
        println("prodaja=  $prodaja")
    }
}

// распечатка таблицы металлов на экран
fun MutableList<Kurs>.printboard() {
    println("имя банка \t валюта \t покупка \t продажа ")
    for (i in this) {
        println(" ${i.namebank} \t ${i.valuta}  \t  ${i.pokupka}  \t  ${i.prodaja}")
    }
}

fun main(args: Array<String>) {
    println("Starting kt-board-money\n")

    var metalkurs: Kurs
    var boardkurs: MutableList<Kurs>  // доска валют
    boardkurs = mutableListOf()
    metalkurs = Kurs()

    //    metalkurs.print()
    boardkurs.add(metalkurs)
    boardkurs.printboard()

    //    println("\nСписок металлов\n $arraykurs")
    println("Stopping kt-board-money")
}