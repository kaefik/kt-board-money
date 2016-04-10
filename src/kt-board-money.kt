/**
 * kt-board-money - доска металлов и валют из банков
 * Created by oilnur on 09.04.16.
 */

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