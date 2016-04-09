/**
 * kt-board-money - доска металлов и валют из банков
 * Created by oilnur on 09.04.16.
 */

class Kurs {
    var namebank: String? = null // название банка
    var valuta: String? = null  //  название валюты
    var pokupka: Float? = null  //  покупка валюты (покупает банк)
    var prodaja: Float? = null  //  продажа валюты  (продает банк)


    fun print() {
        println("namebank= $namebank")
        println("valuta=   $valuta")
        println("pokupka=  $pokupka")
        println("prodaja=  $prodaja")
    }
}

fun List<Kurs>.printboard() {
    println("имя банка \t валюта \t покупка \t продажа \n")
    for (i in this) {
        println("\t $i.namebank")
    }
}

fun main(args: Array<String>) {
    println("Starting kt-board-money\n")

    var metalkurs: Kurs
    var arraykurs: List<Kurs>
    arraykurs = listOf()
    metalkurs = Kurs()

    metalkurs.print()
    arraykurs.printboard()

    //    println("\nСписок металлов\n $arraykurs")
    println("Stopping kt-board-money")
}