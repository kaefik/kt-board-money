/**
 * Created by oilnur on 10.04.16.
 */
data class Kurs (var namebank: String? = null,var valuta: String? = null,var pokupka: Float? = null,var prodaja: Float? = null ){
//    var namebank: String? = null // название банка
//    var valuta: String? = null  //  название валюты
//    var pokupka: Float? = null  //  покупка валюты (покупает банк)
//    var prodaja: Float? = null  //  продажа валюты  (продает банк)

    //парсинг банка с именем nbank, возвращает false - если ошибка парсинга
    fun parsebank(nbank: String?): Boolean {
        when(nbank) {
            "SBRF" -> println("parse SBRF")
            else   -> println("unknown parse")
        }
        return true
    }

    fun print() {
        println("namebank= $namebank")
        println("valuta=   $valuta")
        println("pokupka=  $pokupka")
        println("prodaja=  $prodaja")
    }
}
