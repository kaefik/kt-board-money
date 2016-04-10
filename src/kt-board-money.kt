/**
 * kt-board-money - доска металлов и валют из банков
 * Created by oilnur on 09.04.16.
 */
import java.net.URL
import java.io.File
import java.nio.charset.Charset
import java.util.*


// распечатка таблицы металлов на экран
fun MutableList<Kurs>.printboard() {
    println("имя банка \t валюта \t покупка \t продажа ")
    for (i in this) {
        println(" ${i.namebank} \t ${i.valuta}  \t  ${i.pokupka}  \t  ${i.prodaja}")
    }
}

// парсинг сбербанка котировки металлов
fun MutableList<Kurs>.parsemetalSbrf() {
    var namefile ="htmlpage.html"
    var metal: Kurs
    val linkbank = URL("http://data.sberbank.ru/tatarstan/ru/quotes/metal/?base=beta")
    var CHARSETSBRF=Charset.forName("windows-1251")
    var ff:File
    metal = Kurs()
    metal.namebank = "SBRF"
    metal.valuta = "Au"
//    metal.print()

    var htmlpage:String = linkbank.readText(CHARSETSBRF)

//    println(htmlpage)
//    //схранение строки htmlpage в файле с именем namefile
//    ff= File(namefile)
//    ff.writeText(htmlpage,CHARSETSBRF)
}


fun main(args: Array<String>) {
    println("Starting kt-board-money....\n")

    var metalkurs: Kurs
    var boardkurs: MutableList<Kurs>  // доска валют
    boardkurs = mutableListOf()
    metalkurs = Kurs()

    //    metalkurs.print()
    boardkurs.add(metalkurs)
    boardkurs.printboard()
    boardkurs.parsemetalSbrf()

    //    println("\nСписок металлов\n $arraykurs")
    println("\nStopping kt-board-money....")
}
