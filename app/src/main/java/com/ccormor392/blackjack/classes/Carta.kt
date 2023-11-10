package com.ccormor392.blackjack.classes

class Carta(var palo: Palo, var nombre: Naipe) {
    var puntosMin:Int
    var puntosMax:Int
    var idDrawable:Int
    init {
        if (nombre.valor == 1){
            puntosMax = 11
            puntosMin = 1
        }
        else if (nombre.valor > 10){
            puntosMax = 10
            puntosMin = 10
        }
        else{
            puntosMax = nombre.valor
            puntosMin = nombre.valor
        }
        idDrawable = nombre.valor + 13 * palo.valor
    }
}