/**
 * kt-board-money - доска металлов и валют из банков
 * Created by oilnur on 09.04.16.
 */
import java.net.URL
import java.io.File
import java.nio.charset.Charset
import org.jsoup.*


// распечатка таблицы металлов на экран
fun MutableList<Kurs>.printboard() {
    println("имя банка \t валюта \t покупка \t продажа ")
    for (i in this) {
        println(" ${i.namebank} \t ${i.valuta}  \t  ${i.pokupka}  \t  ${i.prodaja}")
    }
}

// парсинг сбербанка котировки металлов
fun MutableList<Kurs>.parsemetalSbrf() {
    var metal: Kurs
    val linkbank = URL("http://data.sberbank.ru/tatarstan/ru/quotes/metal/?base=beta")
    var CHARSETSBRF = Charset.forName("windows-1251")
    val htmlpage: String = linkbank.readText(CHARSETSBRF)
    // парсинг тэгов таблицы
    val doc = Jsoup.parse(htmlpage)
    val tables = doc.getElementsByTag("table")
    var valmetal: String = ""
    for (i in tables) {
        if (i.attr("class") == "table3_eggs4") {
            valmetal = i.text()
            break
        }
    }

    val arraymetal = valmetal.split(" ")
    metal=Kurs("SBRF","Au")
    metal.pokupka = arraymetal[2].replace(",", ".").toFloat()
    metal.prodaja = arraymetal[3].replace(",", ".").toFloat()
    this.add(metal)
    metal=Kurs("SBRF","Ag")
    metal.pokupka = arraymetal[4].replace(",", ".").toFloat()
    metal.prodaja = arraymetal[5].replace(",", ".").toFloat()
    this.add(metal)
    metal=Kurs("SBRF","Pt")
    metal.pokupka = arraymetal[6].replace(",", ".").toFloat()
    metal.prodaja = arraymetal[7].replace(",", ".").toFloat()
    this.add(metal)
    metal=Kurs("SBRF","Pd")
    metal.pokupka = arraymetal[8].replace(",", ".").toFloat()
    metal.prodaja = arraymetal[9].replace(",", ".").toFloat()
    this.add(metal)
}

//сохранение строки htmlpage в файле с именем namefile
fun SaveFile(namefile: String,htmlpage:String) {
    val CHARSETSBRF = Charset.forName("windows-1251")
    var ff:File = File(namefile)
    ff.writeText(htmlpage, CHARSETSBRF)
}

fun main(args: Array<String>) {
    println("Starting kt-board-money....\n")

//    var metalkurs: Kurs
    var boardkurs: MutableList<Kurs>  // доска валют
    boardkurs = mutableListOf()
//    metalkurs = Kurs()

    //    metalkurs.print()
//    boardkurs.add(metalkurs)
    boardkurs.parsemetalSbrf()
    boardkurs.printboard()
//    println(boardkurs.count())
//    println(boardkurs.first().valuta)
//    println(boardkurs.last().valuta)



    //    println("\nСписок металлов\n $arraykurs")
    println("\nStopping kt-board-money....")
}
