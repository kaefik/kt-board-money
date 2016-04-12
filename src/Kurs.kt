/**
 * Created by oilnur on 10.04.16.
 */
import org.jsoup.Jsoup
import java.net.URL
import java.nio.charset.Charset

data class Kurs (var namebank: String? = null,var valuta: String? = null,var pokupka: Float? = null,var prodaja: Float? = null ){
//    var namebank: String? = null // название банка
//    var valuta: String? = null  //  название валюты
//    var pokupka: Float? = null  //  покупка валюты (покупает банк)
//    var prodaja: Float? = null  //  продажа валюты  (продает банк)

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


// парсинг сбербанка котировки металлов
fun MutableList<Kurs>.parsemetalTfb() {
    var metal: Kurs
    val linkbank = URL("http://tfb.ru/individuals/precious-metal/")
    var CHARSETSBRF = Charset.forName("windows-1251")
    val htmlpage: String = linkbank.readText(CHARSETSBRF)
    // парсинг тэгов таблицы
    val doc = Jsoup.parse(htmlpage)
    val tables = doc.getElementsByTag("div")
    var valmetal: String = ""
    for (i in tables) {
        if (i.attr("id") == "kursi-table") {
            valmetal = i.text()
            break
        }
    }

    val arraymetal = valmetal.split(" ")
    metal=Kurs("TFB","Au")
    metal.pokupka = arraymetal[10].replace(",", ".").toFloat()
    metal.prodaja = arraymetal[11].replace(",", ".").toFloat()
    this.add(metal)
    metal=Kurs("TFB","Ag")
    metal.pokupka = arraymetal[13].replace(",", ".").toFloat()
    metal.prodaja = arraymetal[14].replace(",", ".").toFloat()
    this.add(metal)
    metal=Kurs("TFB","Pt")
    metal.pokupka = arraymetal[16].replace(",", ".").toFloat()
    metal.prodaja = arraymetal[17].replace(",", ".").toFloat()
    this.add(metal)
    metal=Kurs("TFB","Pd")
    metal.pokupka = arraymetal[19].replace(",", ".").toFloat()
    metal.prodaja = arraymetal[20].replace(",", ".").toFloat()
    this.add(metal)
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


