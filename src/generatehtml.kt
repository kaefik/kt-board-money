fun MutableList<Kurs>.genHtml(): String {
    var ss: String = "<TABLE align=\"center\" border=\"1\">"
    ss += "<TR><TD colspan='1' align='center'><B>BANK</B></TD><TD colspan='1' align='center'><B>VALUTA</B></TD><TD colspan='1' align='center'><B>POKUPKA</B></TD><TD colspan='1' align='center'><B>PRODAJA</B></TD></TR>"
    for (n in this) {
        ss += "<TR> <TD> <A href =' #  '>  ${n.namebank} </a> </TD> <TD align='center' > ${n.valuta} </TD> <TD align='center'> ${n.pokupka} </TD>  <TD align='center'> ${n.prodaja}  </TD> </TR> "
    }
    ss += "</TABLE><BR>"
    return HtmlpageBegins() + ss + HtmlpageEnds()

}

// ----------------- функции генерации html page
//-- генерация ячейки таблицы в html
fun tablecell(str: String): String {
    return "<TD> $str </TD>\n"
}

//-- генерация ссылки в html
fun Link(str: String, url: String): String {
    return "<a href=$url > $str </a> <br>\n"
}

//-- генерация строки таблицы в html
fun gentablestroka(str: Array<String>): String {
    var res0: String = ""
    for (i in str) res0 += tablecell(i)
    return "<TR> \n $res0 </TR>\n"
}

// генерация html главной страницы Начало
fun HtmlpageBegins(): String {
    val zagol = "DOSKA METALLOV AND VALUT" //"ДОСКА ВАЛЮТ и МЕТАЛЛОВ"
    val stime = "<br> Vigruzeno:    <br>"    // time.Now().String() + "<br>"" //"<br> Выгружено:  <вывести текущее время и дату>  <br>"    // time.Now().String() + "<br>"
    val begstr = "<html>\n <head>\n <meta charset='utf-8'>\n <title> $zagol </title>\n </head>\n <body>\n <h1 align=\"center\"><a name=\"MainPage\"> DOSKA METALLOV AND VALUT </a></h1> $stime" //"<html>\n <head>\n <meta charset='utf-8'>\n <title> $zagol </title>\n </head>\n <body>\n <h1 align=\"center\"><a name=\"MainPage\"> ДОСКА ВАЛЮТ и МЕТАЛЛОВ </a></h1> $stime"
    return "$begstr <br>"
}

// генерация html главной страницы Конец
fun HtmlpageEnds(): String {
    val endstr = "</body>\n </html>"
    return endstr
}

// шаблон оформления таблицы
fun HtmlTableValuta(ss: String): String {
    val bodystr = "<h3 align=\"center\"></h3><br> <TABLE align=\"center\" border=\"1\"><TR><TD>БАНК</TD><TD>ВАЛЮТА</TD><TD>ПОКУПКА</TD><TD>ПРОДАЖА</TD></TR>"
    return "$bodystr  $ss </TABLE>"
}


//func GenTableKursValuta(board_Valuta []Kurs, linksbanks map[string]string, usdkurspokupka, usdkursprodaja, eurkurspokupka, eurkursprodaja Kurs) string {
//    usdpokupka := usdkurspokupka.Pokupka
//    usdprodaja := usdkursprodaja.Prodaja
//    eurpokupka := eurkurspokupka.Pokupka
//    eurprodaja := eurkursprodaja.Prodaja
//    ss := "<TR><TD colspan='4' align='center'>USD</TD></TR>"
//    //USD
//    for _, v := range board_Valuta {
//        if v.Valuta == "USD" {
//            if usdpokupka == v.Pokupka {
//                ss += "<TR>" + "<TD> <A href ='" + linksbanks[v.Namebank] + "'>" + v.Namebank + "</a></TD>" + "<TD> " + v.Valuta + "</TD>" + "<TD bgcolor='#008000'> " + strconv.FormatFloat(v.Pokupka, 'f', 2, 32) + "</TD>"
//            } else {
//                ss += "<TR>" + "<TD> <A href ='" + linksbanks[v.Namebank] + "'>" + v.Namebank + "</A></TD>" + "<TD> " + v.Valuta + "</TD>" + "<TD> " + strconv.FormatFloat(v.Pokupka, 'f', 2, 32) + "</TD>"
//            }
//            if usdprodaja == v.Prodaja {
//                ss += "<TD bgcolor='#008000'> " + strconv.FormatFloat(v.Prodaja, 'f', 2, 32) + "</TD>" + "</TR>"
//            } else {
//                ss += "<TD> " + strconv.FormatFloat(v.Prodaja, 'f', 2, 32) + "</TD>" + "</TR>"
//            }
//
//        }
//    }
//    //EUR
//    ss += "<TR><TD colspan='4' align='center'>EUR</TD></TR>"
//    //USD
//    for _, v := range board_Valuta {
//        if v.Valuta == "EUR" {
//            if eurpokupka == v.Pokupka {
//                ss += "<TR>" + "<TD> <A href ='" + linksbanks[v.Namebank] + "'>" + v.Namebank + "</A></TD>" + "<TD> " + v.Valuta + "</TD>" + "<TD bgcolor='#008000'> " + strconv.FormatFloat(v.Pokupka, 'f', 2, 32) + "</TD>"
//            } else {
//                ss += "<TR>" + "<TD> <A href ='" + linksbanks[v.Namebank] + "'>" + v.Namebank + "</A></TD>" + "<TD> " + v.Valuta + "</TD>" + "<TD> " + strconv.FormatFloat(v.Pokupka, 'f', 2, 32) + "</TD>"
//            }
//            if eurprodaja == v.Prodaja {
//                ss += "<TD bgcolor='#008000'> " + strconv.FormatFloat(v.Prodaja, 'f', 2, 32) + "</TD>" + "</TR>"
//            } else {
//                ss += "<TD> " + strconv.FormatFloat(v.Prodaja, 'f', 2, 32) + "</TD>" + "</TR>"
//            }
//        }
//    }
//    return ss
//}