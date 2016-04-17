/**
 * kt-board-money - доска металлов и валют из банков
 * Created by oilnur on 09.04.16.
 */

import java.io.File
import java.nio.charset.Charset

//сохранение строки htmlpage в файле с именем namefile
fun SaveFile(namefile: String, htmlpage: String) {
    val CHARSETSBRF = Charset.forName("windows-1251")
    var ff: File = File(namefile)
    ff.writeText(htmlpage, CHARSETSBRF)
}

//fun fsort(Kurs)

fun main(args: Array<String>) {
    println("Starting kt-board-money....\n")
    var boardkurs: MutableList<Kurs>  // доска валют
    boardkurs = mutableListOf()
    boardkurs.parsemetalSbrf()
    boardkurs.parsemetalTfb()
    boardkurs.parsemetalAkbars()
    boardkurs.parsemetalIntechbank()
    boardkurs.parsemetalVtb24()
    boardkurs = (boardkurs.sortedBy { it.valuta }).toMutableList()

    SaveFile("board-metal.html", boardkurs.genHtml())
    println("\nStopping kt-board-money....")
}

